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
import java.util.List;
import java.util.zip.Inflater;

public class AlexCafe extends Fragment {


    public AlexCafe() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View cafeInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        final ListView cafe = cafeInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> cafeList = new ArrayList<>();

        cafeList.add(new Item("Carlos Cafe",new int[]{R.drawable.carlos,R.drawable.carlos2},"6 Km | Beside Mirage Mini Mall, Alexandria 21599, Egypt","+20 3 5226471",R.string.carlos));
        cafeList.add(new Item("Fresca, Four Seasons",new int[]{R.drawable.fresca,R.drawable.fresca2},"399 El Geish Road | Four Seasons Hotel Alexandria at San Stefano, Alexandria 21599, Egypt","+20 3 5818000",R.string.fresca));
        cafeList.add(new Item("Delices",new int[]{R.drawable.delicep,R.drawable.delicep},"46 Saad Zhaghloul Street | Raml Station, Alexandria 21599, Egypt","+20 3 4861432",R.string.empty));
        cafeList.add(new Item("Brazilian Coffee", new int[]{R.drawable.braziliancafe,R.drawable.braziliancafe2},"44 Saad Zaghloul St., Alexandria 21599, Egypt","",R.string.empty));


        cafe.setAdapter(new ItemAdapter(cafeInflater.getContext(),cafeList));

        cafe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(cafeInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",cafeList.get(position).getName());
                detail.putExtra("image",cafeList.get(position).getImg());
                detail.putExtra("address",cafeList.get(position).getAddress());
                detail.putExtra("phone",cafeList.get(position).getPhone());
                detail.putExtra("description",cafeList.get(position).getDescription());
                detail.putExtra("city","Alexandria");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });


        return cafeInflater;
    }

}
