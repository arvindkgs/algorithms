package com.akgs.algo.graph;

import java.util.*;

/**
 * Given an undirected graph with circles, color each node of graph such that neighbouring nodes do
 * not share same color https://gitlab.com/nsajko/example_optimally_colored_graphs
 */
public class ColorGraph {

  static Set<COLOR> colorsUsedInGraph = new HashSet<>();

  public static void printGraph(GraphNode[] graph) {
    Arrays.asList(graph).stream().forEach(System.out::println);
  }

  // TODO: Implement logic
  public static void colorGraph(GraphNode[] graph) {
    if (graph == null || graph.length == 0) return;

    for (int i = 0; i < graph.length; i++) {
      colorUtil(graph[i]);
    }
  }

  private static void colorUtil(GraphNode node) {
    Set<COLOR> neighbourColors = new HashSet<>();
    List<COLOR> unused = new ArrayList<>(Arrays.asList(COLOR.values()));
    for (GraphNode gn : node.getNeighbors()) {
      neighbourColors.add(gn.getColor());
    }
    for (COLOR c : neighbourColors) {
      unused.remove(c);
    }
    COLOR cur = null;
    for (COLOR c : unused) {
      if (colorsUsedInGraph.contains(c)) {
        cur = c;
        break;
      }
    }
    if (cur == null) {
      cur = unused.get(0);
    }
    //        System.out.println("neighbour colors:"+neighbourColors);
    //        System.out.println("colors:"+colorsUsedInGraph);
    //        System.out.println("unused colors:"+unused);
    //        System.out.println("cur:"+cur.toString());
    node.setColor(cur);
    // System.out.println("current color : "+node.getColor());
    colorsUsedInGraph.add(cur);
  }

  public static Set<COLOR> distinctColor(GraphNode[] graph) {
    Set<COLOR> colors = new HashSet<>();
    for (GraphNode node : graph) {
      if (node.hasColor()) colors.add(node.getColor());
    }
    return colors;
  }

  public static void main(String[] args) {
    List<List<Integer>> adjencyList = new ArrayList<>();
    adjencyList.add(List.of(0,1,1,1,1,0,1));
    adjencyList.add(List.of(1,0,1,1,1,0,0));
    adjencyList.add(List.of(1,1,0,1,0,0,0));
    adjencyList.add(List.of(1,1,1,0,1,1,1));
    adjencyList.add(List.of(1,1,0,1,0,0,0));
    adjencyList.add(List.of(0,0,0,1,0,0,0));
    adjencyList.add(List.of(1,0,0,1,0,0,0));
    List<GraphNode> nodes = new ArrayList<>();
    for (int i = 0; i < adjencyList.size(); i++) {
      final GraphNode node = new GraphNode(getNextChar(i));
      nodes.add(node);
    }
    for (int i = 0; i < adjencyList.size(); i++) {
      final List<Integer> edges = adjencyList.get(i);
      final GraphNode node = nodes.get(i);
      System.out.print("Node: "+node.getLabel() + ", neighbors: ");
      for (int j = 0; j < edges.size(); j++) {
        final Integer isEdge = edges.get(j);
        if (isEdge == 1) {
          final GraphNode neighbor = nodes.get(j);
          node.addNeighbor(neighbor);
          System.out.print(neighbor.getLabel() + " ");
        }
      }
      System.out.println();
    }
    /*GraphNode a = new GraphNode("a");
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
    a.addNeighbor(c);
    a.addNeighbor(d);
    b.addNeighbor(a);
    b.addNeighbor(f);
    b.addNeighbor(c);
    c.addNeighbor(a);
    c.addNeighbor(b);
    c.addNeighbor(i);
    d.addNeighbor(a);
    d.addNeighbor(e);
    d.addNeighbor(j);
    e.addNeighbor(d);
    e.addNeighbor(j);
    e.addNeighbor(f);
    f.addNeighbor(e);
    f.addNeighbor(g);
    f.addNeighbor(b);
    g.addNeighbor(k);
    g.addNeighbor(f);
    g.addNeighbor(h);
    h.addNeighbor(g);
    h.addNeighbor(l);
    h.addNeighbor(i);
    i.addNeighbor(h);
    i.addNeighbor(l);
    i.addNeighbor(c);
    j.addNeighbor(d);
    j.addNeighbor(e);
    j.addNeighbor(k);
    k.addNeighbor(j);
    k.addNeighbor(g);
    k.addNeighbor(l);
    l.addNeighbor(k);
    l.addNeighbor(h);
    l.addNeighbor(i);*/

    GraphNode[] graph = nodes.toArray(new GraphNode[0]);
    colorGraph(graph);
    printGraph(graph);
    System.out.println("no of colors = " + distinctColor(graph).size());
  }

  private static String getNextChar(int i) {
    return "" + i;
  }

  public enum COLOR {
    RED,
    GREEN,
    BLUE,
    YELLOW,
    BLACK,
    PURPLE,
    ORANGE,
    VIOLET,
    WHITE,
    MAROON,
    BROWN,
    GREY,
    OFFWHITE,
    BEIGE
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
      return label + ":" + color;
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
      return color.isPresent() ? color.get() : null;
    }

    public void setColor(COLOR color) {
      this.color = Optional.ofNullable(color);
    }
  }
}
