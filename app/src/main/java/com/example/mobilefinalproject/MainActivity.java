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
    private static final int REQUEST_CODE_CARD = 0;;

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

                Intent i = ManualAddCardSuits.newIntent(MainActivity.this, true);
                startActivityForResult(i, REQUEST_CODE_CARD);

            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
