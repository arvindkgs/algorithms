package com.akgs.algo.graph;

import java.util.*;

/**
 * Find order of execution of tasks, given tasks as pairs, where first element represents task, second represent dependency
 * * Assume no cyclic dependency *
 * Ex:
 * input: [(a,b)]
 *  a ─► b
 * output: b,a
 * a is dependent on b, so order of execution: b,a
 * input: [(a,b),(a,c)]
 * ┌──► b
 * │
 * a
 * │
 * └──► c
 * output: b,c,a or c,b,a
 * input: [(a,b),(a,c),(b,d),(c,d),(x,y)]
 * ┌──► b────┐
 * │         ▼
 * a         d
 * │         ▲
 * └──► c────┘
 *  x ─► y
 * output: y,x,d,c,b,a or d,c,b,a,y,x or d,b,c,a,y,x or y,x,d,b,c,a
 */
public class TaskOrdering {

    public static void main(String[] args) {
        char[][] input = new char[5][];
        input[0] = new char[2];
        input[0][0] = 'a';
        input[0][1] = 'b';
        input[1] = new char[2];
        input[1][0] = 'a';
        input[1][1] = 'c';
        input[2] = new char[2];
        input[2][0] = 'b';
        input[2][1] = 'd';
        input[3] = new char[2];
        input[3][0] = 'c';
        input[3][1] = 'd';
        input[4] = new char[2];
        input[4][0] = 'x';
        input[4][1] = 'y';
        findOrdering(input).stream().forEach(System.out::println);
    }

    static class Node {
        public char data;
        public List<Node> neighbors;

        Node(char c) {
            this.data = c;
            neighbors = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            return data == node.data;
        }

        @Override
        public int hashCode() {
            return data;
        }
    }

    static class Graph {
        Map<Node, Node> graph = new HashMap<>();
        public void addEdge(char src, char dest) {
            Node x = new Node(src);
            Node from = graph.get(x);
            if (from == null) {
                graph.put(x, x);
                from = x;
            }
            Node y = new Node(dest);
            Node to = graph.get(y);
            if (to == null) {
                graph.put(y, y);
                to = y;
            }
            from.neighbors.add(to);
        }
        public Set<Node> nodes() {
            return graph.keySet();
        }
    }

    static Graph graph = new Graph();

    static Stack<Node> stack = new Stack();

    private static List<Character> findOrdering(char[][] input) {
        List<Character> orderList = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            graph.addEdge(input[i][0], input[i][1]);
        }
        // Visit graph in DFS and add to stack
        Set<Node> visited = new HashSet<>();
        for (Node node: graph.nodes()) {
            if (!visited.contains(node)){
                dfsOrder(node, visited);
            }
        }
        // Print nodes (if duplicate found, don't print)
        Set<Node> nodeSet = new HashSet<>();
        while (!stack.empty()) {
            Node ele = stack.pop();
            if (nodeSet.add(ele)){
                orderList.add(ele.data);
            }
        }
        return orderList;
    }

    private static void dfsOrder(Node node, Set<Node> visited) {
        visited.add(node);
        stack.add(node);
        for (Node neighbor: node.neighbors) {
            dfsOrder(neighbor, visited);
        }
    }
}
