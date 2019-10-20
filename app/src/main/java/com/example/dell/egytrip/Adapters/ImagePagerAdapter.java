package com.example.dell.egytrip.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.dell.egytrip.R;


public class ImagePagerAdapter extends PagerAdapter {

    int[] images;
    Context context;

    public ImagePagerAdapter(Context c_context, int[] c_images) {

        context = c_context;
        images = c_images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        View viewImage = LayoutInflater.from(context).inflate(R.layout.just_image,null);
        ImageView image = viewImage.findViewById(R.id.itemImages);

        image.setImageResource(images[position]);
        container.addView(viewImage);

        return viewImage;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);

        container.removeView((View) object);
    }
}
