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

public class AlexHistory extends Fragment {

    public AlexHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View historyInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
       ListView history = historyInflater.findViewById(R.id.cityItems);
       final ArrayList<Item> historyList = new ArrayList<>();
       int[] images;

       historyList.add(new Item("Serapeum",images= new int[]{R.drawable.serapeum},"","",R.string.serapeum));
       historyList.add(new Item("Bibliotheca Alexandrina",images= new int[]{R.drawable.library},"","",R.string.library));
       historyList.add(new Item("Alexandria National Museum",images= new int[]{R.drawable.alexmuseum},"","",R.string.alexmus));
       historyList.add(new Item("Montaza Palace",images= new int[]{R.drawable.montazh},"","",R.string.Montaza));
       historyList.add(new Item("Citadel of Qaitbay",images= new int[]{R.drawable.qaitby},"","",R.string.citadelofQaitbay));

       history.setAdapter(new ItemAdapter(historyInflater.getContext(),historyList));

        history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(historyInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",historyList.get(position).getName());
                detail.putExtra("image",historyList.get(position).getImg());
                detail.putExtra("address",historyList.get(position).getAddress());
                detail.putExtra("phone",historyList.get(position).getPhone());
                detail.putExtra("description",historyList.get(position).getDescription());
                detail.putExtra("city","Alexandria");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });

       return historyInflater;
    }


}
