package com.akgs.algo.amazon;

public class SerializeDeserializeBinaryTree {
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Encodes a tree to a single string.
  public static String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildString(root, sb);
    return sb.toString();
  }

  public static void buildString(TreeNode root, StringBuilder sb) {
    if (root == null) {
      sb.append("#,");
      return;
    }
    sb.append(root.val + ",");
    buildString(root.left, sb);
    buildString(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public static TreeNode deserialize(String data) {
    String[] strings = data.split(",");
    return buildTree(strings);
  }

  static int next = 0;

  public static TreeNode buildTree(String[] data) {
    if (next >= data.length) {
      return null;
    }
    String val = data[next];
    if (val.equals("#")) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(val));
    next++;
    node.left = buildTree(data);
    next++;
    node.right = buildTree(data);
    return node;
  }

  public static void main(String[] args) {
    TreeNode tree = new TreeNode(20);
    tree.left = new TreeNode(8);
    tree.right = new TreeNode(22);
    tree.left.left = new TreeNode(4);
    tree.left.right = new TreeNode(12);
    tree.left.right.left = new TreeNode(10);
    tree.left.right.right = new TreeNode(14);
    final String serialize = serialize(tree);
    System.out.println(serialize);
    TreeNode deserializedNode = deserialize(serialize);
    System.out.println(serialize(deserializedNode));
  }
}
