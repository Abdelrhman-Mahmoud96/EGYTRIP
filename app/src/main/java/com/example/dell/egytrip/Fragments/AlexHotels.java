package com.example.dell.egytrip.Fragments;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dell.egytrip.Activities.ItemDetails;
import com.example.dell.egytrip.Adapters.ItemAdapter;
import com.example.dell.egytrip.Classes.Item;
import com.example.dell.egytrip.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlexHotels extends Fragment {


    public AlexHotels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View hotelInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        final ListView hotel = hotelInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> hotelList = new ArrayList<>();
        int[] images;

        hotelList.add(new Item("Four Seasons",images= new int[]{R.drawable.season,R.drawable.season2},"399 El Geish Road , San Stefano, Alexandria, Egypt","",R.string.alexfour));
        hotelList.add(new Item("Steigenberger Cecil Hotel",images= new int[]{R.drawable.steigenberg,R.drawable.steigenberg2},"16 Saad Zagloul Square, Raml Station,Alexandria, Egypt","",R.string.Steigenberge));
        hotelList.add(new Item("Hilton Alexandria Green Plaza",images= new int[]{R.drawable.hilton,R.drawable.hilton2},"14th of May Bridge Road - Smouha, Alexandria, Egypt","",R.string.hiliton));
        hotelList.add(new Item("The Grand Plaza Hotel Smouha",images= new int[]{R.drawable.grandplaza,R.drawable.grandplaza2},"14th May Avenue, Smouha, Alexandria, Egypt","",R.string.plaza));
        hotelList.add(new Item("Royal Crown Hotel",images= new int[]{R.drawable.royal,R.drawable.royal2},"159 Cornish Road, Cleopatra, Alexandria, Egypt","",R.string.royal));

        hotel.setAdapter(new ItemAdapter(hotelInflater.getContext(),hotelList));

        hotel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(hotelInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",hotelList.get(position).getName());
                detail.putExtra("image",hotelList.get(position).getImg());
                detail.putExtra("address",hotelList.get(position).getAddress());
                detail.putExtra("phone",hotelList.get(position).getPhone());
                detail.putExtra("description",hotelList.get(position).getDescription());
                detail.putExtra("city","Alexandria");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });
        return hotelInflater;
    }

}
