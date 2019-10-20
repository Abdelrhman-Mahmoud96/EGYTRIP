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
public class CairoHistory extends Fragment {


    public CairoHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View historyInflater =  inflater.inflate(R.layout.fragment_city_items, container, false);
        final ListView historyList = historyInflater.findViewById(R.id.cityItems);
        final ArrayList<Item> history = new ArrayList<>();
        int[] images;

        history.add(new Item("Pyramids of Giza",images= new int[]{R.drawable.pyramid},"Al Haram, Nazlet El-Semman, Al Haram, Giza Governorate","",R.string.pyramid));
        history.add(new Item("The Egyptian Museum",images= new int[]{R.drawable.museum}," Tahrir Square rd Tahrir Square","",R.string.cairomus));
        history.add(new Item("The Citadel",images= new int[]{R.drawable.catidal},"Al Abageyah, Qesm Al Khalifah، Cairo Governorate","",R.string.Citadel));
        history.add(new Item("Khan el-Khalili",images= new int[]{R.drawable.khan},"El-Gamaleya, El Gamaliya, Cairo Governorate","",R.string.Khalili));
        history.add(new Item("Downtown Cairo",images= new int[]{R.drawable.downtown},"","",R.string.Downtown));

        historyList.setAdapter(new ItemAdapter(historyInflater.getContext(),history));

        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detail = new Intent(historyInflater.getContext(), ItemDetails.class);
                detail.putExtra("name",history.get(position).getName());
                detail.putExtra("image",history.get(position).getImg());
                detail.putExtra("address",history.get(position).getAddress());
                detail.putExtra("phone",history.get(position).getPhone());
                detail.putExtra("description",history.get(position).getDescription());
                detail.putExtra("city","Cairo");

                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(getActivity())
                        .toBundle();
                startActivity(detail,bundle);
            }
        });

        return historyInflater;
    }

}
