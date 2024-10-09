package com.example.smartcity.Iterator;

import com.example.smartcity.dataStructure.AvlTree;
import com.example.smartcity.dataStructure.AvlTreeManager;
import com.example.smartcity.entity.Restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RestaurantIterator implements Iterator<List<Restaurant>> {

    private int curPage = 1;
    private static final int PER_PAGE_LIMITS = 12;
    // TODO: hard core
    private static final int TOTAL_DATA = 3054;
    AvlTree<Restaurant> instance;

    public RestaurantIterator() {
        instance = AvlTreeManager.getInstance();
    }

    @Override
    public boolean hasNext() {
        return curPage * PER_PAGE_LIMITS <= TOTAL_DATA;
    }

    @Override
    public List<Restaurant> next() {
        List<Restaurant> nextPageRes = new ArrayList<>();
        if(this.hasNext()) {
            nextPageRes = instance.toList().subList(curPage * PER_PAGE_LIMITS, ++curPage * PER_PAGE_LIMITS);
            curPage++;
        } else {
            nextPageRes = null;
        }
        return nextPageRes;
    }
}
