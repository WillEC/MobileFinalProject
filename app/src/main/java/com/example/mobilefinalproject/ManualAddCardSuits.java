package com.example.mobilefinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManualAddCardSuits extends AppCompatActivity {

    int returnValue = -1;
    int suite;
    int value;

    private Button mDiamondButton;
    private Button mHeartButton;
    private Button mCloveButton;
    private Button mSpadeButton;
    private Button mBackButton;

    private static final int REQUEST_CODE_NUM = 0;

    public static Intent newIntent(Context packageContent){
        Intent i = new Intent(packageContent, ManualAddCardSuits.class);
        return i;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1) {
            value = resultCode;
            returnValue = (value*4)+suite;
            setResult(returnValue);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card_suits);
        mDiamondButton = (Button) findViewById(R.id.Diamond);
        mHeartButton = (Button) findViewById(R.id.Heart);
        mCloveButton = (Button) findViewById(R.id.Clove);
        mSpadeButton = (Button) findViewById(R.id.Spade);
        mBackButton = (Button) findViewById(R.id.BackSuiteButton);

        mDiamondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int suite = 0;
                Intent i = ManualAddCardNums.newIntent(ManualAddCardSuits.this);
                startActivityForResult(i, REQUEST_CODE_NUM);

            }
        });
        mHeartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int suite = 1;
                Intent i = ManualAddCardNums.newIntent(ManualAddCardSuits.this);
                startActivityForResult(i, REQUEST_CODE_NUM);

            }
        });
        mCloveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int suite = 2;
                Intent i = ManualAddCardNums.newIntent(ManualAddCardSuits.this);
                startActivityForResult(i, REQUEST_CODE_NUM);

            }
        });
        mSpadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int suite = 3;
                Intent i = ManualAddCardNums.newIntent(ManualAddCardSuits.this);
                startActivityForResult(i, REQUEST_CODE_NUM);

            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(returnValue);
                finish();
            }
        });
    }
}
