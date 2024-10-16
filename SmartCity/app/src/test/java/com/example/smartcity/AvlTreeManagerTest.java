package com.example.smartcity;

import com.example.smartcity.backend.dataStructure.AvlTree;
import com.example.smartcity.backend.dataStructure.AvlTreeManager;
import com.example.smartcity.backend.entity.Restaurant;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class AvlTreeManagerTest {

    @Test
    public void testSingletonInstance() {
        AvlTree<Restaurant> instance1 = AvlTreeManager.getInstance();
        AvlTree<Restaurant> instance2 = AvlTreeManager.getInstance();

        assertNotNull(instance1);
        assertNotNull(instance2);
        assertSame(instance1, instance2);
    }

    @Test
    public void testAvlTreeFunctionality() {
        AvlTree<Restaurant> avlTree = AvlTreeManager.getInstance();
        avlTree.insert(new Restaurant(1, "Restaurant A", 4.5, "123 Main St", "http://example.com/photoA.jpg", 40.7128, -74.0060, Arrays.asList("italian", "pizza"), 2, "$25-$50", 100));
        avlTree.insert(new Restaurant(2, "Restaurant B", 4.0, "456 Elm St", "http://example.com/photoB.jpg", 40.7128, -74.0060, Arrays.asList("chinese", "noodles"), 1, "$10-$25", 200));

        assertEquals(2, avlTree.countNodes());
        assertNotNull(avlTree.searchExact("Restaurant A"));
        assertNotNull(avlTree.searchExact("Restaurant B"));
    }
}