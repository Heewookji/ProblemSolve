package p28insertion;

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

public class Util {

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

}