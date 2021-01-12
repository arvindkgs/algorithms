package com.akgs.algo.tree;

import java.util.HashMap;

/**
 * Leet code : https://leetcode.com/problems/path-sum/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        left = right = null;
        this.data = data;
    }

    @Override
    public String toString() {
        return "com.akgs.algo.tree.Node{" +
                "" + data +
                '}';
    }
}

class Tree{
    Node root;
    int result;
    Tree(Node root){
        this.root = root;
        result = 0;
    }
    public int pathSum(int sum) {
        this.result = 0;
        //This map is used to store all sums encountered (and its freq count) in given path upto current node 
        HashMap<Integer, Integer> sum_path = new HashMap<>();
        traverse(root, sum, sum_path, 0);
        return result;
    }

    private void traverse(Node node, int sum, HashMap<Integer, Integer> sum_path, int curr_sum) {
        if(node == null){
            return;
        }
        curr_sum = curr_sum+node.data;

        if(curr_sum == sum){
            result++;
        }

        //This will check if (curr_sum - sum) exists in sum_path map.
        //Meaning that leaving out this value will result in expected sum
        //Implying there is a sub-path possible that equals to expected sum
        //Increment result count by that number, as there can be more than one such occurance
        if(curr_sum > sum && sum_path.containsKey(curr_sum-sum)){
            result+=sum_path.get(curr_sum-sum);
        }

        //Clone map as each child path will irrevocably change the original map 
        sum_path = new HashMap<>(sum_path);
        int count = sum_path.containsKey(curr_sum)? sum_path.get(curr_sum) : 0;
        sum_path.put(curr_sum, count+1);

        traverse(node.left, sum, sum_path, curr_sum);
        traverse(node.right, sum, sum_path, curr_sum);
    }
}

class PathSum {
    public static void main(String[] args) {
        Node root = new Node(10);
        Node left_child = root.left = new Node(5);
        Node right_child = root.right = new Node(-3);
        Node left_left_child = left_child.left = new Node(3);
        Node left_right_child = left_child.right = new Node(2);
        right_child.right = new Node(11);
        left_left_child.left = new Node(3);
        left_left_child.right = new Node(-2);
        left_right_child.right = new Node(1);
        Tree testTree = new Tree(root);
        System.out.println("Pathsum: " + testTree.pathSum(8));
    }
}