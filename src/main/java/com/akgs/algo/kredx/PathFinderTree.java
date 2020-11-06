package com.akgs.algo.kredx;

import java.util.ArrayList;
import java.util.List;

public class PathFinderTree {
    static class Node{
        String data;
        Node left;
        Node right;
        Node(String data){
            left = null;
            right = null;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    /**
     *
     *              a
     *             /\
     *          b       c
     *          /\       \
     *      d       e       f
     *      /\       \
     *     f  g       i
     */

    public static void main(String[] args) {
        List<Node> path = new ArrayList<Node>();
        Node root = new Node("a");
        Node left_child = root.left = new Node("b");
        Node right_child = root.right = new Node("c");
        Node left_left_child = left_child.left = new Node("d");
        Node left_right_child = left_child.right = new Node("e");
        right_child.right = new Node("f");
        left_left_child.left = new Node("g");
        left_left_child.right = new Node("h");
        left_right_child.right = new Node("i");
        System.out.println("------------Path Finder 2------------");
        System.out.println("Prints in reverse order, meaning from target to root node");
        System.out.println("Target : "+right_child);
        List<Node> foundPath = new ArrayList<Node>();
        pathFinder2(root, right_child, foundPath);
        foundPath.stream().forEach(System.out::println);
    }
    private static List<Node> foundPath = new ArrayList<Node>();

    public static boolean pathFinder2(Node curr, Node target, List<Node> foundPath){
        if(curr == null)
            return false;
        if(curr.data == target.data){
            foundPath.add(curr);
            return true;
        }
        if(pathFinder2(curr.left, target, foundPath)){
            foundPath.add(curr);
            return true;
        }
        if(pathFinder2(curr.right, target, foundPath)){
            foundPath.add(curr);
            return true;
        }
        return false;
    }
}
