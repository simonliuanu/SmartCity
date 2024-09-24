package com.example.smartcity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartcity.R;
import com.example.smartcity.adapter.ItemListAdapter;
import com.example.smartcity.entity.Restaurant;
import com.example.smartcity.reader.JsonReader;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment {

    View itemView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemView = inflater.inflate(R.layout.fragment_item, container, false);

        // get the food list
        ListView listView = itemView.findViewById(R.id.item_list);

        // for restaurant test
        // TODO need optimize later, it's a hard code
        Restaurant re1 = new Restaurant("QT Sydney",4.6,"49 Market St, Sydney NSW 2000, Australia","https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=AXCi2Q4qw3nxEDiGZe6qLXZVf5CBiLrU8n-1J1K9E28gf7y4i8ykClDWzcRD8BJh5BiJ3tcNjwnBTAV4sde9Bnx1TacJ2SF_zmbX08M9WSnKBMk4EL9ff-k-PxfbjNmh0VmIELMCQFyJGdUcoPhaV4AOcnqC2x2oA0S-xpcl9MJDtGHsQAzd&key=AIzaSyAccaWZx1OpDqA2oJYts6egNAleMyBa86o");
        Restaurant re2 = new Restaurant("Swissôtel Sydney",4.3,"68 Market St, Sydney NSW 2000, Australia","https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=AXCi2Q7FmNqHDzHq1QihHqMqeGF3Pe_loRRfi5FcL7bgR43iCv3U8sfW9ottSYI88BKU4_pbumHwUwzO3jLckqk_voShBaXT4wmLEyJ_9m9ztVRE3r76knBsXy-O73yLxIl-kYFGdqe0HPcV0ya5GJNgMmml_buf5X1eaGISIKIl7iYpJ-ln&key=AIzaSyAccaWZx1OpDqA2oJYts6egNAleMyBa86o");
        Restaurant re3 = new Restaurant("The Little Snail Restaurant",4.5,"3/50 Murray St, Pyrmont NSW 2009, Australia","https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=AXCi2Q7_YbEAYCAtGgXiPIWNkKEc3uowMCI0taHH0CkEg6doVLEraCuk10rAR9aoVyOTdCtNZR1JPU_RRhwUFFbiPSpLByKJvNBmQWF4DkaFVHmWNUBkrxsQ6i7n0vIC_uzadp69L-XITPiwJ5MjWs3crVdHtiIzXjiY71UUVCtaO-6SQqsX&key=AIzaSyAccaWZx1OpDqA2oJYts6egNAleMyBa86o");
        Restaurant re4 = new Restaurant("Amora Hotel Jamison Sydney",4.2,"11 Jamison St, Sydney NSW 2000, Australia","https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=AXCi2Q7y63qs_kk5lamzzASDD0O6LMzL_mWc1VDr5KWx3pVt2DWOMkmiapFy7yw_cfQ1V2yFeOse9Pn0x_XbXbIxDlWnvpjtLSpAyD190y2PVSI2Q953zzNupDEfbo_JlKwa2fvPu2S1FAR9NZ8l3pHrDfH8PafZTjnbcR-9Xmqk8cjO4Ajt&key=AIzaSyAccaWZx1OpDqA2oJYts6egNAleMyBa86o");
        Restaurant re5 = new Restaurant("Castlereagh Boutique Hotel, Ascend Hotel Collection",3.9,"169 Castlereagh St, Sydney NSW 2000, Australia","https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=AXCi2Q6QhX_PIDlFavK9XumDC32i6JBu7LCbLBRiDgkyieXImxL_aIdQMsODA_eBN6B9PzkMgsVOf9Gw5sOx0ORFnz6P-cGjxrphzYCHyvwettBEee9eJ4RK2XymRvw9TzFOhRMBdqGeHStdzRyir4db5WRFARsu2_s4mi_cmK-2TG-lzSvY&key=AIzaSyAccaWZx1OpDqA2oJYts6egNAleMyBa86o");
        List<Restaurant> resList = new ArrayList<>();
        resList.add(re1);
        resList.add(re2);
        resList.add(re3);
        resList.add(re4);
        resList.add(re5);


        ItemListAdapter itemListAdapter = new ItemListAdapter(getContext(), resList);
        if(resList.isEmpty()) {
            listView.setAdapter(null);
        } else {
            listView.setAdapter(itemListAdapter);
        }

        return itemView;
    }
}
