package com.example.smartcity.reader;

import com.example.smartcity.entity.Restaurant;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class GsonJsonReader {

    // 解析 JSON 数据
    public static List<Restaurant> readJsonFromFile(Context context, String fileName) {
        try {
            // 打开文件
            InputStream inputStream = context.getAssets().open(fileName);

            // 将文件内容读入 InputStreamReader
            InputStreamReader reader = new InputStreamReader(inputStream);

            // 使用 Gson 进行解析
            Gson gson = new Gson();
            Type restaurantListType = new TypeToken<List<Restaurant>>(){}.getType();
            List<Restaurant> restaurantList = gson.fromJson(reader, restaurantListType);

            // 关闭流
            reader.close();
            inputStream.close();

            // 日志输出解析的数量和信息
            System.out.println("Parsed restaurants count: " + restaurantList.size());
//            for (Restaurant restaurant : restaurantList) {
//                System.out.println(restaurant.toString());
//            }

            return restaurantList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
