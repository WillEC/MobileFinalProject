package com.example.mobilefinalproject;

import android.widget.Switch;

/**
 * Created by William Chen on 1/24/2017.
 */
public class Card {
    char suite;
    int value;

    public Card(char s, int v){
        suite = s;
        value = v;
    }

    public char getSuite() {
        return suite;
    }

    public void setSuite(char suite) {
        this.suite = suite;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        String s = "";
        String v = "";

        switch(suite){
            case 'D':
                s = "diamond";
                break;
            case 'H':
                s = "heart";
                break;
            case 'C':
                s = "clove";
                break;
            case 'S':
                s = "spade";
                break;
            default:
                s = "N/A";
        }

        switch(value){
            case 11:
                v = "Jack";
                break;
            case 12:
                v = "Queen";
                break;
            case 13:
                s = "King";
                break;
            default:
                s = value + "";
        }

        return v + " of " + s;
    }
}
