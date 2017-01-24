package com.example.mobilefinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManualAddCardNums extends AppCompatActivity {

    private Button mAButton;
    private Button mTwoButton;
    private Button mThreeButton;
    private Button mFourButton;
    private Button mFiveButton;
    private Button mSixButton;
    private Button mSevenButton;
    private Button mEightButton;
    private Button mNineButton;
    private Button mTenButton;
    private Button mJButton;
    private Button mQButton;
    private Button mKButton;
    private Button mBackButton;


    public static Intent newIntent(Context packageContent){
        Intent i = new Intent(packageContent, ManualAddCardNums.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card_nums);

        mAButton = (Button) findViewById(R.id.Ace);
        mTwoButton = (Button) findViewById(R.id.Two);
        mThreeButton = (Button) findViewById(R.id.Three);
        mFourButton = (Button) findViewById(R.id.Four);
        mFiveButton = (Button) findViewById(R.id.Five);
        mSixButton = (Button) findViewById(R.id.Six);
        mSevenButton = (Button) findViewById(R.id.Seven);
        mEightButton = (Button) findViewById(R.id.Eight);
        mNineButton = (Button) findViewById(R.id.Nine);
        mTenButton = (Button) findViewById(R.id.Ten);
        mJButton = (Button) findViewById(R.id.Jack);
        mQButton = (Button) findViewById(R.id.Queen);
        mKButton = (Button) findViewById(R.id.King);
        mBackButton = (Button) findViewById(R.id.BackNumButton);


        mAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });
        mTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(1);
                finish();
            }
        });
        mThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(2);
                finish();
            }
        });
        mFourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(3);
                finish();
            }
        });
        mFiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(4);
                finish();
            }
        });
        mSixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(5);
                finish();
            }
        });
        mSevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(6);
                finish();
            }
        });
        mEightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(7);
                finish();
            }
        });
        mNineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(8);
                finish();
            }
        });
        mTenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(9);
                finish();
            }
        });
        mJButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(10);
                finish();
            }
        });
        mQButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(11);
                finish();
            }
        });
        mKButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(12);
                finish();
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
