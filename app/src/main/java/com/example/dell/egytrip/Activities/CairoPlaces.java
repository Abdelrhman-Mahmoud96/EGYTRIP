package com.example.dell.egytrip.Activities;

import android.app.ActivityOptions;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dell.egytrip.Adapters.CairoPagerAdapter;
import com.example.dell.egytrip.R;

public class CairoPlaces extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_places);

        ViewPager cairoPager = findViewById(R.id.cityPager);
        TabLayout cairoTab = findViewById(R.id.cityTab);

        cairoPager.setAdapter(new CairoPagerAdapter(getSupportFragmentManager()));
        cairoTab.setupWithViewPager(cairoPager);
        cairoTab.setTabTextColors(R.color.colorPrimaryDark, Color.parseColor("#ffffff"));


    }
}
