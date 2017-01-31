package com.example.mobilefinalproject;

import android.widget.Switch;

/**
 * Created by William Chen on 1/24/2017.
 */
public class Card extends Object{
    private int suite;
    private int value;

    public Card(int s, int v){
        suite = s;
        value = v;
    }

    public int getSuite() {
        return suite;
    }

    public void setSuite(int suite) {
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

        switch(value){
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
                v = value + "";
        }

        return v + " of " + s;
    }
    public int CardToInt(){
        return ((value-1)*4)+(suite-1);
    }
    public int compareTo(Card other){
        if (other.getValue() == this.value && other.getSuite() == this.suite)
            return 0;
        else return -1;
    }
}
