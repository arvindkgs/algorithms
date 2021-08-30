package com.akgs.algo.graph;

import java.util.*;

/**
 * Given an undirected graph, color each node of graph such that neighbouring nodes do not share same color
 */
public class ColorGraph {

    public enum COLOR{
        RED, BLUE, GREEN, YELLOW, BLACK, PURPLE, ORANGE, VIOLET, WHITE, MAROON, BROWN, GREY, OFFWHITE, BEIGE
    }

    public static class GraphNode {
        private String label;
        private Set<GraphNode> neighbors;
        private Optional<COLOR> color;

        public GraphNode(String label) {
            this.label = label;
            neighbors = new HashSet<GraphNode>();
            color = Optional.empty();
        }

        @Override
        public String toString() {
            return label+":"+color;
        }

        public String getLabel() {
            return label;
        }

        public Set<GraphNode> getNeighbors() {
            return Collections.unmodifiableSet(neighbors);
        }

        public void addNeighbor(GraphNode neighbor) {
            neighbors.add(neighbor);
        }

        public boolean hasColor() {
            return color.isPresent();
        }

        public COLOR getColor() {
            return color.isPresent()? color.get(): null;
        }

        public void setColor(COLOR color) {
            this.color = Optional.ofNullable(color);
        }
    }

    public static void printGraph(GraphNode[] graph) {
        Arrays.asList(graph).stream().forEach(System.out::println);
    }

    //TODO: Implement logic
    public static void colorGraph(GraphNode[] graph){

    }

    public static Set<COLOR> distinctColor(GraphNode[] graph){
        Set<COLOR> colors = new HashSet<>();
        for(GraphNode node: graph){
            colors.add(node.getColor());
        }
        return colors;
    }

    public static void main(String[] args) {
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");
        GraphNode d = new GraphNode("d");
        GraphNode e = new GraphNode("e");
        GraphNode f = new GraphNode("f");
        GraphNode g = new GraphNode("g");
        GraphNode h = new GraphNode("h");
        GraphNode i = new GraphNode("i");
        GraphNode j = new GraphNode("j");
        GraphNode k = new GraphNode("k");
        GraphNode l = new GraphNode("l");

        a.addNeighbor(b);
        a.addNeighbor(d);
        b.addNeighbor(f);
        b.addNeighbor(c);
        c.addNeighbor(a);
        c.addNeighbor(i);
        d.addNeighbor(e);
        d.addNeighbor(j);
        e.addNeighbor(j);
        e.addNeighbor(f);
        f.addNeighbor(g);
        g.addNeighbor(k);
        g.addNeighbor(h);
        h.addNeighbor(l);
        h.addNeighbor(i);
        i.addNeighbor(l);
        j.addNeighbor(k);
        k.addNeighbor(l);

        GraphNode[] graph = new GraphNode[] { a, b, c, d, e, f, g, h, i, j, k, l };
        colorGraph(graph);
        printGraph(graph);
        System.out.println("no of colors = " + distinctColor(graph).size());
    }
}
