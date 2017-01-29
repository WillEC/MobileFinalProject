package com.example.mobilefinalproject;

import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class VoiceAddCard extends AppCompatActivity {

    private ImageButton mListenButton;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;
    private TextView mConfirmationText;
    String mResult;
    private int mNum = -1;
    private int mSuite = -1;


    public static Intent newIntent(Context packageContent){
        Intent i = new Intent(packageContent, VoiceAddCard.class);
        return i;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ArrayList<String> results;
        results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        mResult = "Did you say: ";
        for (int i = 0; i < results.size(); i++){
            mResult += results.get(i).toLowerCase() + " ";
        }

        if (mResult.contains("diamond")) mSuite = 0;
        else if (mResult.contains("heart")) mSuite = 1;
        else if (mResult.contains("club")) mSuite = 2;
        else if (mResult.contains("spade")) mSuite = 3;

        if (mResult.contains("ace")) mNum = 0;
        else if (mResult.contains("two") || mResult.contains("too") || mResult.contains("to")) mNum = 1;
        else if (mResult.contains("three")) mNum = 2;
        else if (mResult.contains("four") || mResult.contains("for")) mNum = 3;
        else if (mResult.contains("five")) mNum = 4;
        else if (mResult.contains("six")) mNum = 5;
        else if (mResult.contains("seven")) mNum = 6;
        else if (mResult.contains("eight") || mResult.contains("ate")) mNum = 7;
        else if (mResult.contains("nine")) mNum = 8;
        else if (mResult.contains("ten")) mNum = 9;
        else if (mResult.contains("jack")) mNum = 10;
        else if (mResult.contains("queen")) mNum = 11;
        else if (mResult.contains("king")) mNum = 12;

        if (mSuite != -1 && mNum != -1){
            String s = "";
            String v = "";

            switch(mSuite){
                case 0:
                    s = "diamond";
                    break;
                case 1:
                    s = "heart";
                    break;
                case 2:
                    s = "club";
                    break;
                case 3:
                    s = "spade";
                    break;
                default:
                    s = "N/A";
            }

            switch(mNum+1){
                case 1:
                    v = "Ace";
                    break;
                case 11:
                    v = "Jack";
                    break;
                case 12:
                    v = "Queen";
                    break;
                case 13:
                    v = "King";
                    break;
                default:
                    v = (mNum+1) + "";
            }

            mResult = "Did you say: " + v + " of " + s + "?";
            mConfirmationText.setText(mResult);
        }
        else {
            mConfirmationText.setText("please try again");
            mSuite = -1;
            mNum = -1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card_voice);

        mListenButton = (ImageButton) findViewById(R.id.VoiceButton);
        mYesButton = (Button) findViewById(R.id.YesButton);
        mNoButton = (Button) findViewById(R.id.NoButton);
        mBackButton = (Button) findViewById(R.id.BackButton);
        mConfirmationText = (TextView) findViewById(R.id.ConfirmationText);

        mListenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start speaking (e.g. four of clubs)");
                i.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
                i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(i, 2);
            }
        });
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSuite != -1 && mNum != -1) {
                    setResult((mNum*4)+mSuite);
                    finish();
                }
            }
        });
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConfirmationText.setText("");
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(-1);
                finish();
            }
        });
    }
}
