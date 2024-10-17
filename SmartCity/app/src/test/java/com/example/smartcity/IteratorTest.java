package com.example.smartcity;

import com.example.smartcity.backend.Iterator.RestaurantRepository;
import com.example.smartcity.backend.dataStructure.AvlTree;
import com.example.smartcity.backend.dataStructure.AvlTreeManager;
import com.example.smartcity.backend.entity.Restaurant;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    private Iterator resIterator;
    private RestaurantRepository resRepo;

    @Before
    public void setup() {
        resRepo = new RestaurantRepository();
        resIterator = resRepo.getIterator();
    }
    @Test
    public void testLoadPageData() {
        resRepo.setCurPage(0);

        // mock insert data in avl tree
        AvlTree instance = AvlTreeManager.getInstance();
        for (int i = 1; i <= 28; i++) {
            instance.insert(new Restaurant(i, "Restaurant" + i, 3.5, "789 Oak St", "http://example.com/photoC.jpg", 40.7128, -74.0060, Arrays.asList("mexican", "tacos"), 3, "$50-$100", 150));
        }

        // first page have 12 items, equals to PER_PAGE_LIMITS
        List<Restaurant> firstPage = (List<Restaurant>) resIterator.next();
        Assert.assertFalse(firstPage.isEmpty());
        Assert.assertEquals(12, firstPage.size());

        // second page have data
        List<Restaurant> secondPage = (List<Restaurant>) resIterator.next();
        Assert.assertFalse(secondPage.isEmpty());
    }

    @Test
    public void testLoadExcessiveData() {
        // set a page more than data
        resRepo.setCurPage(400);
        Assert.assertFalse(resIterator.hasNext());
        List<Restaurant> noNextPage = (List<Restaurant>) resIterator.next();
        Assert.assertNull(noNextPage);
    }
}
