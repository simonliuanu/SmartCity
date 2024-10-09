package com.example.smartcity.dao;

import com.example.smartcity.entity.Restaurant;
import com.example.smartcity.util.DataCallback;

import java.util.List;

public interface ItemDao {

    /**
     * This method used to initial the data in item page
     * @param callback
     */
    void initialItemList(final DataCallback<List<Restaurant>> callback);
}
