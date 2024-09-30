package com.example.smartcity.reader;

import com.example.smartcity.entity.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    public List<Restaurant> parseJsonToRestaurantList(String jsonString) {
        List<Restaurant> restaurants = new ArrayList<>();

        try {
            // 解析整个 JSON 数组
            JSONArray jsonArray = new JSONArray(jsonString);

            // 遍历每个 JSON 对象
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // 获取各字段值
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                double rating = jsonObject.optDouble("rating", -1);  // 使用 optDouble 以防字段缺失
                String address = jsonObject.getString("address");
                String photoUrl = jsonObject.optString("photo_url", "");  // 默认空字符串，避免 photo_url 缺失时的异常
                double latitude = jsonObject.getDouble("latitude");
                double longitude = jsonObject.getDouble("longitude");

                // 解析 types 字段的数组，并转换为 String[]
                JSONArray typesArray = jsonObject.getJSONArray("types");
                String[] types = new String[typesArray.length()];
                for (int j = 0; j < typesArray.length(); j++) {
                    types[j] = typesArray.getString(j);
                }


                // 处理可能为 null 的字段
                String priceLevel = jsonObject.optString("price_level", "Unknown");
                String estimatedPrice = jsonObject.optString("estimated_price", "Unknown");
                int userRatingsTotal = jsonObject.optInt("user_ratings_total", 0);  // 使用 optInt 防止字段缺失

                // 创建 Restaurant 对象并添加到列表中
                Restaurant restaurant = new Restaurant(
                        id,
                        name,
                        rating,
                        address,
                        photoUrl,
                        latitude,
                        longitude,
                        types,
                        priceLevel,
                        estimatedPrice,
                        userRatingsTotal
                );
                restaurants.add(restaurant);
            }
        } catch (JSONException e) {
            // 捕获和处理异常
            System.err.println("Failed to parse JSON: " + e.getMessage());
            e.printStackTrace();
        }

        return restaurants;
    }
}