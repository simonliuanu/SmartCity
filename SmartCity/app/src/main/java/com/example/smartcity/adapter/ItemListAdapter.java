package com.example.smartcity.adapter;

import android.content.Context;
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
        super(context, R.layout.item_list,list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // use viewHolder to solve the repeat list in list view
        ViewHolder holder;
        // if null, create a new view
        if(convertView == null) {
            LayoutInflater from = LayoutInflater.from(getContext());
            // appear a bug on attachToRoot, without false, will
            // show  addView(View, LayoutParams) is not supported in AdapterView
            convertView = from.inflate(R.layout.item_list, parent,false);
            // Initialize the ViewHolder and find the views
            holder = new ViewHolder();

            // store the list attribute in view holder
            holder.holdImage = convertView.findViewById(R.id.item_image);
            holder.holdName = convertView.findViewById(R.id.item_restaurant_name);
            holder.holdAddress = convertView.findViewById(R.id.item_restaurant_address);
            holder.holdRate = convertView.findViewById(R.id.item_restaurant_rate);
            holder.holdPrice = convertView.findViewById(R.id.item_restaurant_price);
            holder.holdType = convertView.findViewById(R.id.item_restaurant_type);

            // Store the holder with the view
            convertView.setTag(holder);
        } else {
            // Retrieve the holder
            holder = (ViewHolder) convertView.getTag();
        }

        Restaurant curRestaurant = list.get(position);

        Glide.with(convertView.getContext()).load(curRestaurant.getPhoto_url()).into(holder.holdImage);
        holder.holdName.setText(curRestaurant.getName());
        holder.holdAddress.setText(curRestaurant.getAddress());
        holder.holdRate.setText(String.valueOf(curRestaurant.getRating())); // Make sure to convert rating to string
        holder.holdPrice.setText(curRestaurant.getEstimated_price());

        System.out.println(curRestaurant.getName() + ", 所得 position 值为: " + position);

        return convertView;
    }

    static class ViewHolder {
        ImageView holdImage;
        TextView holdName;
        TextView holdAddress;
        TextView holdRate;
        TextView holdPrice;
        TextView holdType;
    }
}
