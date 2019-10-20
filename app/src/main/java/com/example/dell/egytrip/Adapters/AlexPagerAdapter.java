package com.example.dell.egytrip.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dell.egytrip.Fragments.AlexCafe;
import com.example.dell.egytrip.Fragments.AlexHistory;
import com.example.dell.egytrip.Fragments.AlexHotels;
import com.example.dell.egytrip.Fragments.AlexRestaurants;
import com.example.dell.egytrip.Fragments.AlexShopping;
import com.example.dell.egytrip.Fragments.CairoCafe;
import com.example.dell.egytrip.Fragments.CairoHistory;
import com.example.dell.egytrip.Fragments.CairoHotels;
import com.example.dell.egytrip.Fragments.CairoRestaurants;
import com.example.dell.egytrip.Fragments.CairoShopping;

public class AlexPagerAdapter extends FragmentPagerAdapter {


    public AlexPagerAdapter(FragmentManager fm) {

        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new AlexHotels();
            case 1:
                return new AlexRestaurants();
            case 2:
                return new AlexCafe();
            case 3:
                return new AlexShopping();
            case 4:
                return new AlexHistory();



        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
               return  "Hotels";
            case 1:
                return  "Restaurants";
            case 2:
                return  "Cafe";
            case 3:
                return  "Shopping";
            case 4:
                return  "History";
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
