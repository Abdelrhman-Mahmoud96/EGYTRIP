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

public class CairoHotels extends Fragment {




    public CairoHotels() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View hotelInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        ListView hotelsList = hotelInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> hotels = new ArrayList<>();
        int[] images;

        hotels.add(new Item("Le Passage",images= new int[]{R.drawable.lepassage},"","",R.string.LePassage));
        hotels.add(new Item("Kempinski Nile Hotel",images= new int[]{R.drawable.kempinskinilehotel,R.drawable.kempinskinilehotel2},"12 Ahmed Ragheb Street | Cornish El-Nile, Garden City, Cairo, Egypt","02 27980000",R.string.Kempinski));
        hotels.add(new Item("Sonesta Hotel, Tower & Casino",images= new int[]{R.drawable.sonestahoteltowercasino,R.drawable.sonestahoteltowercasino2},"3 El Tayaran Street, Nasr City, Cairo, Egypt","",R.string.Sonesta));
        hotels.add(new Item("Almasa CairoHotels",images= new int[]{R.drawable.almasahotels,R.drawable.almasahotels2},"Abdel Aziz El Shennawy St | Behind The Stage, Nasr City, Cairo, Egypt","",R.string.Almasa));
        hotels.add(new Item("Sofitel Cairo El Gezirah",images= new int[]{R.drawable.sofitelcairoelgezirah,R.drawable.sofitelcairoelgezirah2},"3 El Thawra Council St Zamalek, Cairo, Egypt","02 27373737",R.string.Sofitel));

        hotelsList.setAdapter(new ItemAdapter(hotelInflater.getContext(),hotels));

        hotelsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(hotelInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",hotels.get(position).getName());
                detail.putExtra("image",hotels.get(position).getImg());
                detail.putExtra("address",hotels.get(position).getAddress());
                detail.putExtra("phone",hotels.get(position).getPhone());
                detail.putExtra("description",hotels.get(position).getDescription());
                detail.putExtra("city","Cairo");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });

        return hotelInflater;
    }


}
