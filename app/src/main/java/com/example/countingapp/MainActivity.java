package com.example.countingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void countOdds (View view) {
        OddCounter odds = new OddCounter(this);

        Thread oddThread = new Thread(odds, "Count by Odds ");
        oddThread.start();
    }

    public void countEvens (View view) {
        EvenCounter evens = new EvenCounter(this);

        Thread evenThread = new Thread(evens, "Count by Evens ");
        evenThread.start();
    }
}
