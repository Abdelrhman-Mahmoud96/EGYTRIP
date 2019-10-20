package com.example.dell.egytrip.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.egytrip.R;

public class MainActivity extends AppCompatActivity {

    private static int timer = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent cities = new Intent(MainActivity.this,Cities.class);
                startActivity(cities);
                finish();
            }
        },timer);
    }
}
