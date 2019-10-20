package com.example.dell.egytrip.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.dell.egytrip.Adapters.ImagePagerAdapter;
import com.example.dell.egytrip.R;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ItemDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        Bundle bundel = getIntent().getExtras();
        final String itemName = bundel.getString("name");
        int[] itemImages = bundel.getIntArray("image");
        String itemAddress = bundel.getString("address");
        String itemPhone = bundel.getString("phone");
        final String itemCity = bundel.getString("city");
        int itemDescription = bundel.getInt("description");

        TextView addressView = findViewById(R.id.itemAddress);
        TextView phoneView = findViewById(R.id.itemContact);
        TextView descriptionView = findViewById(R.id.itemDescription);
        ViewPager imagePager = findViewById(R.id.imagePager);



        addressView.setText(itemAddress);
        phoneView.setText(itemPhone);
        descriptionView.setText(itemDescription);
        imagePager.setAdapter(new ImagePagerAdapter(this, itemImages));

        if (descriptionView.getText().toString().matches("")) {
            descriptionView.setVisibility(View.GONE);
        }


        Button locationBtn = findViewById(R.id.locationBtn);
        locationBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {

                    String location = "https://www.google.com/maps/dir/?api=1&destination="+itemName+"+"+itemCity+"&travelmode=driving";
                    Uri itemLocation =  Uri.parse(location);
                    Intent map = new Intent(Intent.ACTION_VIEW,itemLocation);

                    map.setPackage("com.google.android.apps.maps");
                if (map.resolveActivity(getPackageManager()) != null) {
                    startActivity(map);
                }

            }
        });

        Slide slide = new Slide(Gravity.BOTTOM);
        slide.addTarget(R.id.itemDescription);
        slide.addTarget(R.id.itemAddress);
        slide.addTarget(R.id.itemContact);
        slide.setInterpolator(AnimationUtils
                .loadInterpolator(this, android.R.interpolator.linear_out_slow_in));
        slide.setDuration(1000);
        getWindow().setEnterTransition(slide);

    }


}
