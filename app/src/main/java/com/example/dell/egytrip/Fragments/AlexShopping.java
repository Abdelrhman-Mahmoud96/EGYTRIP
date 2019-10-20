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


public class AlexShopping extends Fragment {


    public AlexShopping() {
        // Required empty public constructor
    }
        
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View shopInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        final ListView shop = shopInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> shopsList = new ArrayList<>();
        int[] images;

        shopsList.add(new Item("City Centre",images= new int[]{R.drawable.alexcitycenter},"Cairo Alex Desert Rd, Qetaa at Tarik as Sahrawi, Qesm Al Amereyah, Alexandria","",R.string.alexcity));
        shopsList.add(new Item("Carrefour City Center",images= new int[]{R.drawable.carfo},"Gate 4 - 1st Alexandria Cairo Desert Road - Alexandria","",R.string.empty));
        shopsList.add(new Item("Green Plaza Mall",images= new int[]{R.drawable.greenplaza},"14 may Road - Sidi Gaber - Smoha","",R.string.empty));
        shopsList.add(new Item("Deeb Mall",images= new int[]{R.drawable.deep},"1 Syria Street، Roushdy","",R.string.deeb));


        shop.setAdapter(new ItemAdapter(shopInflater.getContext(),shopsList));

        shop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(shopInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",shopsList.get(position).getName());
                detail.putExtra("image",shopsList.get(position).getImg());
                detail.putExtra("address",shopsList.get(position).getAddress());
                detail.putExtra("phone",shopsList.get(position).getPhone());
                detail.putExtra("description",shopsList.get(position).getDescription());
                detail.putExtra("city","Alexandria");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });
        return shopInflater;
    }




}
