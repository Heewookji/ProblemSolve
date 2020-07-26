package p28insertion;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      int[] shiftedArr = new int[n];
      int[] arr = new int[n];
      for (int j = 0; j < n; j++)
        shiftedArr[j] = sc.nextInt();
      find(n, arr, shiftedArr);
      for (int j = 0; j < n; j++)
        System.out.print(arr[j] + " ");
      System.out.println();
    }
  }

  private static void find(int n, int[] arr, final int[] shiftedArr) {
    Node candidates = null;
    for (int i = 0; i < n; i++)
      candidates = Util.insert(candidates, new Node(i + 1));
      System.out.println();
    for (int i = n - 1; i >= 0; i--) {
      int larger = shiftedArr[i];
      Node kthNode = Util.kth(candidates, i + 1 - larger);
      arr[i] = kthNode.getKey();
      candidates = Util.erase(candidates, kthNode.getKey());
    }
  }
}



class NodePair {

  private Node first;
  private Node second;

  public NodePair(Node first, Node second) {
    this.first = first;
    this.second = second;
  }

  public Node getFirst() {
    return this.first;
  }

  public Node getSecond() {
    return this.second;
  }

}

class Util {

  public static NodePair split(Node root, int key) {
    if (root == null)
      return new NodePair(null, null);
    if (root.getKey() < key) {
      NodePair rs = split(root.getRight(), key);
      root.setRight(rs.getFirst());
      return new NodePair(root, rs.getSecond());
    }
    NodePair ls = split(root.getLeft(), key);
    root.setLeft(ls.getFirst());
    return new NodePair(ls.getFirst(), root);
  }

  public static Node insert(Node root, Node node) {
    if (root == null)
      return node;
    if (root.getPriority() < node.getPriority()) {
      NodePair splitted = split(root, node.getKey());
      node.setLeft(splitted.getFirst());
      node.setLeft(splitted.getFirst());
      node.setRight(splitted.getSecond());
      return node;
    } else if (node.getKey() < root.getKey())
      root.setLeft(insert(root.getLeft(), node));
    else
      root.setRight(insert(root.getRight(), node));
    return root;
  }

  public static Node merge(Node a, Node b) {
    if (a == null)
      return b;
    if (b == null)
      return a;
    if (a.getPriority() < b.getPriority()) {
      b.setLeft(merge(a, b.getLeft()));
      return b;
    }
    a.setRight(merge(a.getRight(), b));
    return a;
  }

  public static Node erase(Node root, int key) {
    if (root == null)
      return root;
    if (root.getKey() == key)
      return merge(root.getLeft(), root.getRight());
    if (root.getKey() > key)
      root.setLeft(erase(root.getLeft(), key));
    else
      root.setRight(erase(root.getRight(), key));
    return root;
  }

  public static Node kth(Node root, int nth) {
    int leftSize = 0;
    if (root.getLeft() != null)
      leftSize = root.getLeft().getSize();
    if (nth <= leftSize)
      return kth(root.getLeft(), nth);
    if (nth == leftSize + 1)
      return root;
    return kth(root.getRight(), nth - leftSize - 1);
  }

  public static int countLessThan(Node root, int key) {
    if (root == null)
      return 0;
    Node left = root.getLeft();
    if (root.getKey() >= key)
      return countLessThan(left, key);
    int leftSize = left != null ? left.getSize() : 0;
    return leftSize + 1 + countLessThan(root.getRight(), key);
  }

}

class Node {

  private int key, priority, size;
  private Node left, right;

  public Node(int key) {
    this.key = key;
    this.priority = (int) (Math.random() * 100);
    this.size = 1;
  }

  public void setLeft(Node newLeft) {
    this.left = newLeft;
    caculateSize();
  }

  public void setRight(Node newRight) {
    this.right = newRight;
    caculateSize();
  }

  public Node getLeft() {
    return this.left;
  }

  public Node getRight() {
    return this.right;
  }

  public int getSize() {
    return this.size;
  }

  public int getKey() {
    return this.key;
  }

  public int getPriority() {
    return this.priority;
  }

  private void caculateSize() {
    size = 1;
    if (left != null)
      size += left.getSize();
    if (right != null)
      size += right.getSize();
  }

}