package com.example.smartcity.backend.dao;

import com.example.smartcity.backend.entity.Restaurant;
import com.example.smartcity.util.DataCallback;

import java.util.List;

/**
 * @author Shengzong Dai (u7811526)
 */
public interface ItemDao {

    /**
     * This method used to initial the data in item page
     * @param callback The callback to handle the response.
     */
    void initialItemList(final DataCallback<List<Restaurant>> callback);
}
