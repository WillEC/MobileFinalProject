package com.example.mobilefinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ManualAddCardSuits extends AppCompatActivity {

    public static Intent newIntent(Context packageContent, boolean answerIsTrue){
        Intent i = new Intent(packageContent, ManualAddCardSuits.class);
        i.putExtra("temp", 1);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_card_suits);
    }
}
