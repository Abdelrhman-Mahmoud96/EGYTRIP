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
public class AlexRestaurants extends Fragment {


    public AlexRestaurants() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View restaurantInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        final ListView restaurant = restaurantInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> restaurantList = new ArrayList<>();
        int[] images;

        restaurantList.add(new Item("China House",images= new int[]{R.drawable.chinahousececilresto},"16, Saad Zagloul Square, Raml Station","",R.string.china));
        restaurantList.add(new Item("Greek Club Restaurant",images= new int[]{R.drawable.greek_club},"Qaitbay Street, El-Anfoushy (Inside the Greek Club) on the Third Floor","",R.string.greek));
        restaurantList.add(new Item("San Giovanni Restaurant",images= new int[]{R.drawable.sangiovanni},"205 El Geish Road, Stanly","",R.string.sangiovany));
        restaurantList.add(new Item("Santa Lucia",images= new int[]{R.drawable.santalucia,R.drawable.santalucia2},"40 Safia Zagloul Street, Raml Station","",R.string.santa));
        restaurantList.add(new Item("Calithea",images= new int[]{R.drawable.calithea},"83 El-Geish Road, Raml Station","",R.string.Calithea));

        restaurant.setAdapter(new ItemAdapter(restaurantInflater.getContext(),restaurantList));

        restaurant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(restaurantInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",restaurantList.get(position).getName());
                detail.putExtra("image",restaurantList.get(position).getImg());
                detail.putExtra("address",restaurantList.get(position).getAddress());
                detail.putExtra("phone",restaurantList.get(position).getPhone());
                detail.putExtra("description",restaurantList.get(position).getDescription());
                detail.putExtra("city","Alexandria");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });
        return restaurantInflater;
    }

}
