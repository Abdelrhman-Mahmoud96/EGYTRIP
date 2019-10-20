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

/**
 * A simple {@link Fragment} subclass.
 */
public class CairoShopping extends Fragment {


    public CairoShopping() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View shopInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        ListView shopsList = shopInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> shops = new ArrayList<>();
        int[] images;

        shops.add(new Item("Cairo Festival City Mall",images= new int[]{R.drawable.cariofest2,R.drawable.cariofest},"","",R.string.empty));
        shops.add(new Item("City Stars Mall",images= new int[]{R.drawable.citystars,R.drawable.citystars2},"Omar Ibn El Khattab St. Off El Nasr Rd. Heliopolis, Cairo","",R.string.empty));
        shops.add(new Item("Mall of Arabia",images= new int[]{R.drawable.mallelarab,R.drawable.mallelarab2},"Mehwer 26th July,6th of October City | Juhaynah Square, Cairo","",R.string.el3rb));
        shops.add(new Item("Mall of Egypt",images= new int[]{R.drawable.mallmasr,R.drawable.mallmasr2}," Al Wahat Al Baharia, Giza Governorate","",R.string.mallmasr));
        shops.add(new Item("The District",images= new int[]{R.drawable.thedistinct,R.drawable.thedistinct2},"Al Matar, El Nozha, Cairo Governorate","",R.string.District));

        shopsList.setAdapter(new ItemAdapter(shopInflater.getContext(),shops));

        shopsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(shopInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",shops.get(position).getName());
                detail.putExtra("image",shops.get(position).getImg());
                detail.putExtra("address",shops.get(position).getAddress());
                detail.putExtra("phone",shops.get(position).getPhone());
                detail.putExtra("description",shops.get(position).getDescription());
                detail.putExtra("city","Cairo");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });

        return shopInflater;
    }

}
