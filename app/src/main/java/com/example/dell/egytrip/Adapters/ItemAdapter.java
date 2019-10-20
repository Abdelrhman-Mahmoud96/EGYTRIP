package com.example.dell.egytrip.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.egytrip.Classes.Item;
import com.example.dell.egytrip.R;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {


    public ItemAdapter(@NonNull Context context, ArrayList<Item> cities) {
        super(context,0,cities);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View cityView = convertView;

        if (cityView == null)
        {
            cityView = LayoutInflater.from(getContext()).inflate(R.layout.item_card,parent,false);
        }
        Item itemObject = getItem(position);

        TextView cityName = cityView.findViewById(R.id.cityName);
        ImageView cityImage = cityView.findViewById(R.id.cityImg);
        int[] images = itemObject.getImg();

        cityName.setText(itemObject.getName());
        cityImage.setImageResource(images[0]);



        return cityView;

    }


}
