package p39timetrip;

import java.util.PriorityQueue;
import java.util.Scanner;

class WormHole {

  private int num;
  private int cost;

  public WormHole(int num, int cost) {
    this.cost = cost;
    this.num = num;
  }

  public int getCost() {
    return cost;
  }

  public int getNum() {
    return num;
  }

}

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      int w = scanner.nextInt();
      int[][] adj = new int[n][n];
      for (int j = 0; j < w; j++)
        adj[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
      int[] dist = new int[n];
      solve(0, adj, dist);
    }
  }

  private static int solve(final int start, final int[][] adj, int[] dist) {

    PriorityQueue<WormHole> pQueue = new PriorityQueue<>();
    pQueue.add(new WormHole(start, 0));
    return 0;
  }

}