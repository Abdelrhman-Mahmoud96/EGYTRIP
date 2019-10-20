package com.example.dell.egytrip.Activities;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.egytrip.Adapters.AlexPagerAdapter;
import com.example.dell.egytrip.R;

public class AlexPlaces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_places);

        ViewPager alexPager = findViewById(R.id.cityPager);
        TabLayout alexTab = findViewById(R.id.cityTab);

        alexPager.setAdapter(new AlexPagerAdapter(getSupportFragmentManager()));
        alexTab.setupWithViewPager(alexPager);
        alexTab.setTabTextColors(R.color.colorPrimaryDark, Color.parseColor("#ffffff"));
    }
}
