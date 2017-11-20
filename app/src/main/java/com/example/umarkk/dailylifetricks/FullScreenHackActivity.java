package com.example.umarkk.dailylifetricks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FullScreenHackActivity extends AppCompatActivity {

    public static int pos = 0;
    private int pos_clicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_hack);

        Intent intent = getIntent();

    }
}
