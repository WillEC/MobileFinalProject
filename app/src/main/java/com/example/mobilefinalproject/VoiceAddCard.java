package com.example.mobilefinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class VoiceAddCard extends AppCompatActivity {

    private ImageButton mListenButton;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;
    private int num = -1;


    public static Intent newIntent(Context packageContent){
        Intent i = new Intent(packageContent, VoiceAddCard.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card_voice);

        mListenButton = (ImageButton) findViewById(R.id.VoiceButton);
        mYesButton = (Button) findViewById(R.id.YesButton);
        mNoButton = (Button) findViewById(R.id.NoButton);
        mBackButton = (Button) findViewById(R.id.BackButton);

        mListenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(-1);
                finish();
            }
        });
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(num);
                finish();
            }
        });
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
