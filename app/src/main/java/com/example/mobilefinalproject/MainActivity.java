package com.example.mobilefinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mAddCardButton;
    private Button mResetButton;
    private TextView mCountTextView;
    private TextView mCardsTextView;
    private int mCount = 0;
    private Card[] cards = new Card[52];
    private static final int REQUEST_CODE_CARD = 0;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1){
            char suite;
            switch(resultCode%4){
                case 0:
                    suite = 'D';
                    break;
                case 1:
                    suite = 'H';
                    break;
                case 2:
                    suite = 'C';
                    break;
                case 3:
                    suite = 'S';
                    break;
                default:
                    suite = 'i';
            }

            int value = (resultCode/4)+1;

            cards[mCount] = new Card(suite, value);
            mCount++;
        }
    }

    public void reset() {
        mCount = 0;
        cards = new Card[52];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddCardButton = (Button) findViewById(R.id.AddCardButton);
        mResetButton = (Button) findViewById(R.id.ResetButton);
        mCountTextView = (TextView) findViewById(R.id.CounterText);
        mCardsTextView = (TextView) findViewById(R.id.DealtCardsText);

        mAddCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = ManualAddCardSuits.newIntent(MainActivity.this);
                startActivityForResult(i, REQUEST_CODE_CARD);

            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String card = "Cards that have been entered: ";
                for(int i = 0; i < mCount-1; i++){
                    card = card+" "+cards[i]+",";
                }
                card = card+" " + cards[mCount].toString();

                mCardsTextView.setText(card);
                //reset();
            }
        });
    }
}
