package p26fortress;

import java.util.ArrayList;
import java.util.Scanner;

class Node {

  private ArrayList<Node> children = new ArrayList<>();

  public ArrayList<Node> getChildren() {
    return this.children;
  }
}

public class Main {

  static int longest;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
    }

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

  private static int solve(Node root){
    longest = 0;
    int h = height(root);
    return Math.max(longest, h);
  }

}
