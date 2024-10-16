package com.example.smartcity.backend.dataStructure;

import com.example.smartcity.backend.entity.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * AvlTree is an AVL tree implementation specifically for the Restaurant class.
 * It supports insertion, searching, and traversal operations.
 * It is used to store and manage Restaurant data in a balanced binary search tree.
 */
public class AvlTree {
    public static class Node {
        private Restaurant data;
        private Node left;
        private Node right;
        private int height;

        public Node(Restaurant data) {
            this.data = data;
            this.height = 1;
        }

        public Restaurant getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getHeight() {
            return height;
        }

        public String toString() {
            return data.toString();
        }
    }

    private Node root;

    // Insert a Restaurant into the AVL tree
    public void insert(Restaurant data) {
        root = insert(root, data);
    }

    private Node insert(Node node, Restaurant data) {
        if (node == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return balance(node);
    }

    // Search for an exact match by name
    public Restaurant searchExact(String name) {
        return searchExact(root, name);
    }

    public Restaurant searchExact(Node node, String name) {
        if (node == null) {
            return null;
        }
        Restaurant restaurant = node.data;
        int cmp = name.compareTo(restaurant.getName());
        if (cmp < 0) {
            return searchExact(node.left, name);
        } else if (cmp > 0) {
            return searchExact(node.right, name);
        } else {
            return node.data;
        }
    }

    // Search for nodes whose names contain the given prefix
    public List<Restaurant> searchByContains(String prefix) {
        List<Restaurant> list = new ArrayList<>();
        searchByContains(root, prefix, list);
        return list;
    }

    public void searchByContains(Node node, String prefix, List<Restaurant> list) {
        if (node == null) {
            return;
        }
        Restaurant restaurant = node.data;
        if (restaurant.getName().contains(prefix)) {
            list.add(node.data);
        }
        searchByContains(node.left, prefix, list);
        searchByContains(node.right, prefix, list);
    }

    // Convert the AVL tree to a list in order
    public List<Restaurant> toList() {
        List<Restaurant> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(Node node, List<Restaurant> list) {
        if (node != null) {
            inOrderTraversal(node.left, list);
            list.add(node.data);
            inOrderTraversal(node.right, list);
        }
    }

    // Balance the AVL tree
    private Node balance(Node node) {
        if (node == null) return null;

        int balance = height(node.left) - height(node.right);
        if (balance > 1) {
            if (height(node.left.left) < height(node.left.right)) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        } else if (balance < -1) {
            if (height(node.right.right) < height(node.right.left)) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }
        return node;
    }

    // Rotate the subtree left
    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }

    // Rotate the subtree right
    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        newRoot.height = 1 + Math.max(height(newRoot.left), height(newRoot.right));
        return newRoot;
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // Calculate the total number of nodes
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public Node getRoot() {
        return root;
    }
}
