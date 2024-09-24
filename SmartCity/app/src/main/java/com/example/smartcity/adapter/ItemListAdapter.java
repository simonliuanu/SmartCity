package com.example.smartcity.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.smartcity.R;
import com.example.smartcity.entity.Restaurant;

import java.util.List;

/**
 * used to show the restaurant list adapter
 * the adapter catch the item_list layout and put
 * the attribute List<Restaurant> in the list layout
 * once it be called by the itemFragment
 * the listView in itemFragment will be filled by the item_list.xml
 */
public class ItemListAdapter extends ArrayAdapter<Restaurant> {

    private List<Restaurant> list;

    private Context context;

    public ItemListAdapter(@NonNull Context context, List<Restaurant> list) {
        super(context, R.layout.item_list, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // if null, create a new view
        if (convertView == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            // appear a bug on attachToRoot, without false, will
            // show  addView(View, LayoutParams) is not supported in AdapterView
            convertView = from.inflate(R.layout.item_list, parent, false);


            Restaurant curRestaurant = list.get(position);

            ImageView resImage = convertView.findViewById(R.id.item_image);
            TextView resName = convertView.findViewById(R.id.item_restaurant_name);
            TextView resAddress = convertView.findViewById(R.id.item_restaurant_address);
            TextView resRate = convertView.findViewById(R.id.item_restaurant_rate);

            Glide.with(convertView).load(curRestaurant.getPhotoUrl()).into(resImage);

            resName.setText(curRestaurant.getName());
            resAddress.setText(curRestaurant.getAddress());
            /*            resRate.setText((int) curRestaurant.getRating());*/
        }

        return convertView;
    }
}
