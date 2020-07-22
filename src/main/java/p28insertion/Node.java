package p28insertion;

class Node {

  private int key, priority, size;
  private Node left, right;

  public Node(int key) {
    this.key = key;
    this.priority = (int) Math.random();
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