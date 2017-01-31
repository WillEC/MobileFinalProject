package com.example.mobilefinalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button mAddCardButton;
    private Button mResetButton;
    private RadioButton mManualSetting;
    private RadioButton mVoiceSetting;
    private TextView mCountTextView;
    private TextView mCardsTextView;
    private int mCount = 0;
    private Set<Card> cards = new HashSet<Card>();
    private static final int REQUEST_CODE_CARD = 1;
    private static final String CARDS_KEY = "cards";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1){
            int value = (resultCode/4)+1;
            int suite = (resultCode%4);

            boolean alreadyPlayed = false;
            Card next = new Card(suite, value);
            for (Card c: cards)
                if (c.compareTo(next)==0)
                    alreadyPlayed = true;
            if(alreadyPlayed) {
                Toast.makeText(MainActivity.this, "Already played!", Toast.LENGTH_SHORT).show();
            }
            else{
                if (value == 1 || value >= 10) mCount--;
                else if (value <= 6) mCount++;

                mCountTextView.setText("Count: "+mCount);
                cards.add(next);

                String card = "Cards that have been entered: " + cards;

                mCardsTextView.setText(card);
            }


        }
    }

    public void reset() {
        mCount = 0;
        cards = new HashSet<Card>();
        mCardsTextView.setText("Cards that have been entered: N/A");
        mCountTextView.setText("Count: N/A");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddCardButton = (Button) findViewById(R.id.AddCardButton);
        mResetButton = (Button) findViewById(R.id.ResetButton);
        mCountTextView = (TextView) findViewById(R.id.CounterText);
        mCardsTextView = (TextView) findViewById(R.id.DealtCardsText);
        mManualSetting = (RadioButton) findViewById(R.id.ManualInputSetting);
        mManualSetting.setChecked(true);
        mVoiceSetting = (RadioButton) findViewById(R.id.VoiceInputSetting);

        SharedPreferences settings = getPreferences(0);
        Set<String> temp = new HashSet<String>();
        temp = settings.getStringSet(CARDS_KEY, temp);

        int tempCount = 0;
        for(String s: temp){
            int tempInt = Integer.parseInt(s);

            int value = (tempInt/4)+1;
            int suite = (tempInt%4);

            if (value == 1 || value >= 10) mCount--;
            else if (value <= 6) mCount++;

            mCountTextView.setText("Count: "+mCount);

            cards.add( new Card(suite, value));

            String card = "Cards that have been entered: " + cards;

            mCardsTextView.setText(card);
        }

        mAddCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mManualSetting.isChecked()) {
                    Intent i = ManualAddCardSuits.newIntent(MainActivity.this);
                    startActivityForResult(i, REQUEST_CODE_CARD);
                }
                else if(mVoiceSetting.isChecked()){
                    Intent i = VoiceAddCard.newIntent(MainActivity.this);
                    startActivityForResult(i, REQUEST_CODE_CARD);
                }
                else{
                    Toast.makeText(MainActivity.this, "Select Input Type", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        Set<String> temp = new HashSet<String>();
        for(Card c: cards){
            temp.add(c.CardToInt()+"");
        }
        SharedPreferences settings = getPreferences(0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putStringSet(CARDS_KEY, temp);
        editor.apply();
    }
}
