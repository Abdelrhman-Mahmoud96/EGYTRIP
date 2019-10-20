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
public class CairoRestaurants extends Fragment {


    public CairoRestaurants() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View restaurantInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        ListView restaurantsList = restaurantInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> restaurants = new ArrayList<>();
        int[] images;

        restaurants.add(new Item("The Grill Restaurant & Lounge",images= new int[]{R.drawable.grill},"Semiramis InterContinental, Garden City, Cairo, Cairo, Cairo Governorate","02 27988000",R.string.empty));
        restaurants.add(new Item("Andrea",images= new int[]{R.drawable.andrea_el_mariouteya}," 124 El-Sayed El-Merghany, Almazah, Heliopolis, Cairo Governorate","02 24152758",R.string.andria));
        restaurants.add(new Item("Il Piccolo Mondo, Le Pacha 1901",images= new int[]{R.drawable.le_pacha_1901,R.drawable.le_pacha_19012},"Saraya El Giza,zamalek,Giza Governorate","02 27356730",R.string.Piccolo));
        restaurants.add(new Item("Abou El Sid",images= new int[]{R.drawable.abouelsid1,R.drawable.aboside10},"157 26th of July Corridor, St, El Zamalek, Giza Governorate","02 27359640",R.string.AbouElSid));


        restaurantsList.setAdapter(new ItemAdapter(restaurantInflater.getContext(),restaurants));

        restaurantsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(restaurantInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",restaurants.get(position).getName());
                detail.putExtra("image",restaurants.get(position).getImg());
                detail.putExtra("address",restaurants.get(position).getAddress());
                detail.putExtra("phone",restaurants.get(position).getPhone());
                detail.putExtra("description",restaurants.get(position).getDescription());
                detail.putExtra("city","Cairo");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });

        return restaurantInflater;
    }

}
