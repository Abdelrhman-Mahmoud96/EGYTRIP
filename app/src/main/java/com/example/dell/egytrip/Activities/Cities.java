package com.example.dell.egytrip.Activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell.egytrip.Adapters.ItemAdapter;
import com.example.dell.egytrip.Classes.Item;
import com.example.dell.egytrip.R;

import java.util.ArrayList;

public class Cities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        ArrayList<Item> cities = new ArrayList<>();
        final Context context = Cities.this;
        int[] images;
        cities.add(new Item("Cairo",images= new int[]{R.drawable.cairothme},"","",R.string.empty));
        cities.add(new Item("Alexandria",images= new int[]{R.drawable.alexandria},"","",R.string.empty));
        ListView cityList = findViewById(R.id.citiesList);
        cityList.setAdapter(new ItemAdapter(this,cities));

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position)
                {
                    case 0:
                        Intent cairoIntent = new Intent(Cities.this,CairoPlaces.class);
                        startActivity(cairoIntent);
                        break;
                    case 1:
                        Intent alexIntent = new Intent(Cities.this,AlexPlaces.class);
                        startActivity(alexIntent);
                        break;

                }
            }
        });

    }
}
