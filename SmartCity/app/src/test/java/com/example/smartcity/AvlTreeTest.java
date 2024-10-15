package com.example.smartcity;

import com.example.smartcity.backend.dataStructure.AvlTree;
import com.example.smartcity.backend.entity.Restaurant;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class AvlTreeTest {

    private AvlTree<Restaurant> avlTree;

    @Before
    public void setUp() {
        avlTree = new AvlTree<>();
        avlTree.insert(new Restaurant(1, "Restaurant C", 3.5, "789 Oak St", "http://example.com/photoC.jpg", 40.7128, -74.0060, Arrays.asList("mexican", "tacos"), 3, "$50-$100", 150));
        avlTree.insert(new Restaurant(2, "Restaurant B", 4.0, "456 Elm St", "http://example.com/photoB.jpg", 40.7128, -74.0060, Arrays.asList("chinese", "noodles"), 1, "$10-$25", 200));
        avlTree.insert(new Restaurant(3, "Restaurant A", 4.5, "123 Main St", "http://example.com/photoA.jpg", 40.7128, -74.0060, Arrays.asList("italian", "pizza"), 2, "$25-$50", 100));
    }

    @Test
    public void testInsert() {
        avlTree.insert(new Restaurant(4, "Restaurant D", 4.2, "101 Pine St", "http://example.com/photoD.jpg", 40.7128, -74.0060, Arrays.asList("japanese", "sushi"), 2, "$25-$50", 120));
        assertEquals(4, avlTree.countNodes());
    }

    @Test
    public void testSearchExact() {
        Restaurant result = avlTree.searchExact("Restaurant B");
        assertNotNull(result);
        assertEquals("Restaurant B", result.getName());
    }

    @Test
    public void testSearchExactNotFound() {
        Restaurant result = avlTree.searchExact("Restaurant X");
        assertNull(result);
    }

    @Test
    public void testSearchByContains() {
        List<Restaurant> results = avlTree.searchByContains("Restaurant");
        assertEquals(3, results.size());
    }

    @Test
    public void testToList() {
        List<Restaurant> list = avlTree.toList();
        assertEquals(3, list.size());
        assertEquals("Restaurant A", list.get(0).getName());
        assertEquals("Restaurant B", list.get(1).getName());
        assertEquals("Restaurant C", list.get(2).getName());
    }

    @Test
    public void testCountNodes() {
        assertEquals(3, avlTree.countNodes());
    }

    @Test
    public void testBalance() {
        avlTree.insert(new Restaurant(4, "Restaurant D", 4.2, "101 Pine St", "http://example.com/photoD.jpg", 40.7128, -74.0060, Arrays.asList("japanese", "sushi"), 2, "$25-$50", 120));
        avlTree.insert(new Restaurant(5, "Restaurant E", 4.8, "202 Maple St", "http://example.com/photoE.jpg", 40.7128, -74.0060, Arrays.asList("french", "bakery"), 3, "$50-$100", 80));
        assertEquals(5, avlTree.countNodes());
        assertTrue(isBalanced(avlTree.getRoot()));
    }

    @Test
    public void testRotateRight() {
        // This will trigger a right rotation
        avlTree.insert(new Restaurant(4, "Restaurant D", 4.2, "101 Pine St", "http://example.com/photoD.jpg", 40.7128, -74.0060, Arrays.asList("japanese", "sushi"), 2, "$25-$50", 120));
        avlTree.insert(new Restaurant(5, "Restaurant E", 4.8, "202 Maple St", "http://example.com/photoE.jpg", 40.7128, -74.0060, Arrays.asList("french", "bakery"), 3, "$50-$100", 80));
        avlTree.insert(new Restaurant(6, "Restaurant F", 4.9, "303 Birch St", "http://example.com/photoF.jpg", 40.7128, -74.0060, Arrays.asList("indian", "curry"), 3, "$50-$100", 90));
        assertTrue(isBalanced(avlTree.getRoot()));
    }

    @Test
    public void testHeight() {
        assertEquals(2, avlTree.getRoot().getHeight());
    }

    @Test
    public void testToString() {
        String treeString = avlTree.toString();
        assertNotNull(treeString);
        assertTrue(treeString.contains("Restaurant A"));
        assertTrue(treeString.contains("Restaurant B"));
        assertTrue(treeString.contains("Restaurant C"));
    }

    private boolean isBalanced(AvlTree.Node<Restaurant> node) {
        if (node == null) return true;
        int leftHeight = node.getLeft() != null ? node.getLeft().getHeight() : 0;
        int rightHeight = node.getRight() != null ? node.getRight().getHeight() : 0;
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.getLeft()) && isBalanced(node.getRight());
    }
}