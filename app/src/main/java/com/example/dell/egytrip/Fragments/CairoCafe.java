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

import com.example.dell.egytrip.Activities.Cities;
import com.example.dell.egytrip.Activities.ItemDetails;
import com.example.dell.egytrip.Adapters.ItemAdapter;
import com.example.dell.egytrip.Classes.Item;
import com.example.dell.egytrip.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CairoCafe extends Fragment {


    public CairoCafe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View cafeInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        ListView cafesList = cafeInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> cafes = new ArrayList<>();
        int[] images;

        cafes.add(new Item("El Fishawy Cafe",images= new int[]{R.drawable.fishawy},"El-Gamaleya, El Gamaliya, Cairo Governorate","",R.string.fishawy));
        cafes.add(new Item("Naguib Mahfouz Cafe",images= new int[]{R.drawable.mahfouz},"Sekat Al Badstan, St، Qesm Gamaleyah، Cairo Governorate","",R.string.mahfoz));
        cafes.add(new Item("Kafein",images= new int[]{R.drawable.kafeen},"Address: 20 Adly, Downtown، Abdeen, Cairo Governorate","0100 042 7902",R.string.kafien));
        cafes.add(new Item("Cafe Corniche",images= new int[]{R.drawable.cornich},"Corniche El Nil, Garden City, Cairo, cairo, Cairo Governorate","",R.string.cornish));
        cafes.add(new Item("Left Bank",images= new int[]{R.drawable.leftbank},"53 End, Abou El Feda","",R.string.LeftBank));

        cafesList.setAdapter(new ItemAdapter(cafeInflater.getContext(),cafes));

        cafesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(cafeInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",cafes.get(position).getName());
                detail.putExtra("image",cafes.get(position).getImg());
                detail.putExtra("address",cafes.get(position).getAddress());
                detail.putExtra("phone",cafes.get(position).getPhone());
                detail.putExtra("description",cafes.get(position).getDescription());
                detail.putExtra("city","Cairo");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });

        return cafeInflater;
    }

}
