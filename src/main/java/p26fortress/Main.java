package p26fortress;

import java.util.ArrayList;
import java.util.Scanner;

class Node {

  private ArrayList<Node> children = new ArrayList<>();

  public ArrayList<Node> getChildren() {
    return this.children;
  }
}

class Wall {

  private int x;
  private int y;
  private int radius;

  public Wall(int x, int y, int radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public Boolean isParentOf(Wall child, ArrayList<Wall> walls) {
    if (!this.encloses(child))
      return false;
    for (int i = 0; i < walls.size(); i++) {
      Wall another = walls.get(i);
      if (!this.equals(another) && !child.equals(another) && this.encloses(another) && another.encloses(child))
        return false;
    }
    return true;
  }

  private Boolean encloses(Wall child) {
    return this.radius > child.radius && this.sqrdist(child) > Math.pow(this.radius - child.radius, 2);
  }

  private double sqrdist(Wall another) {
    return Math.pow(this.x - another.x, 2) + Math.pow(this.y - another.y, 2);
  }

  @Override
  public boolean equals(Object obj) {
    Wall another = (Wall) obj;
    return this.x == another.x && this.y == another.y && this.radius == another.radius;
  }

  @Override
  public String toString() {
    return "x = " + this.x + " y = " + this.y + " r = " + this.radius;
  }

}

public class Main {

  static int longest;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      ArrayList<Wall> walls = new ArrayList<>();
      for (int j = 0; j < n; j++)
        walls.add(new Wall(sc.nextInt(), sc.nextInt(), sc.nextInt()));
      Node root = getTree(0, walls);
      System.out.println(solve(root));
    }
  }

  private static int solve(Node root) {
    longest = 0;
    int h = height(root);
    return Math.max(longest, h);
  }

  private static int height(Node root) {

    ArrayList<Integer> heights = new ArrayList<>();

    for (int i = 0; i < root.getChildren().size(); i++)
      heights.add(height(root.getChildren().get(i)));
    if (heights.isEmpty())
      return 0;
    heights.sort(null);
    if (heights.size() >= 2)
      longest = Math.max(longest, 2 + heights.get(heights.size() - 2) + heights.get(heights.size() - 1));
    return heights.get(heights.size() - 1) + 1;
  }

  private static Node getTree(int root, final ArrayList<Wall> walls) {
    Node ret = new Node();
    for (int node = 0; node < walls.size(); node++)
      if (walls.get(root).isParentOf(walls.get(node), walls))
        ret.getChildren().add(getTree(node, walls));
    return ret;
  }

}
