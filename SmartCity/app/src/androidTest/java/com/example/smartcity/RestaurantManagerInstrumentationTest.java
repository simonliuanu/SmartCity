package com.example.smartcity;

import android.content.Context;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.smartcity.dataStructure.AvlTree;
import com.example.smartcity.entity.Restaurant;
import com.example.smartcity.entity.RestaurantManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class RestaurantManagerInstrumentationTest {

    private RestaurantManager manager;

    @Before
    public void setUp() {
        // 使用 ApplicationProvider 获取实际的 Context
        Context context = ApplicationProvider.getApplicationContext();
        manager = RestaurantManager.getInstance(context);
    }

    //test restaurant avltree
    @Test
    public void testGetRestaurantTree() {
        AvlTree<Restaurant> tree = manager.getRestaurantTree();
        assertNotNull("Restaurant tree should not be null", tree);
        System.out.println(tree.toString());
        // 进一步的断言取决于你的具体实现
        // assertTrue("Restaurant tree should have elements", tree.size() > 0);
        // 打印树的节点数量
        int nodeCount = tree.countNodes();
        System.out.println("Number of nodes in the AVL tree: " + nodeCount);
    }
}
