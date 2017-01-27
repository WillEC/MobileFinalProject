package com.example.mobilefinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mAddCardButton;
    private Button mResetButton;
    private RadioButton mManualSetting;
    private RadioButton mVoiceSetting;
    private TextView mCountTextView;
    private TextView mCardsTextView;
    private int mCurrCard = 0;
    private int mCount = 0;
    private Card[] cards = new Card[52];
    private static final int REQUEST_CODE_CARD = -1;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1){
            int value = (resultCode/4)+1;
            int suite = (resultCode%4);

            if (value <= 6) mCount++;
            else if (value >= 10) mCount--;

            mCountTextView.setText("Count: "+mCount);

            cards[mCurrCard] = new Card(suite, value);
            mCurrCard++;

            String card = "Cards that have been entered: ";
            for(int i = 0; i < mCurrCard -1; i++){
                card = card+" "+cards[i].toString()+",";
            }
            card = card+" " + cards[mCurrCard -1].toString();

            mCardsTextView.setText(card);
        }
    }

    public void reset() {
        mCurrCard = 0;
        mCount = 0;
        cards = new Card[52];
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
}
