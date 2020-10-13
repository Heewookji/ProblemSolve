package p39timetrip;

import java.util.ArrayList;
import java.util.Arrays;
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

  final static int MAX = Integer.MAX_VALUE;
  final static int MIN = Integer.MIN_VALUE;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      int w = scanner.nextInt();
      ArrayList<WormHole>[] adj = new ArrayList[n];
      for (int j = 0; j < n; j++)
        adj[j] = new ArrayList<>();
      for (int j = 0; j < w; j++)
        adj[scanner.nextInt()].add(new WormHole(scanner.nextInt(), scanner.nextInt()));
      int[] upper = new int[n];
      int[] lower = new int[n];
      Arrays.fill(upper, MAX);
      Arrays.fill(lower, MIN);
      boolean[][] reachable = new boolean[n][n];

      int ret1 = solve(0, 1, adj, upper, reachable);
      int ret2 = solve2(0, 1, adj, lower, reachable);

      if (ret1 == MAX)
        System.out.println("UNREACHABLE");
      else
        System.out.println((ret1 == MIN ? "INFINITY" : ret1) + " " + (ret2 == MAX ? "INFINITY" : ret2));
    }
  }

  private static int solve(final int start, final int target, final ArrayList<WormHole>[] adj, int[] upper,
      boolean[][] reachable) {
    upper[start] = 0;
    for (int iter = 0; iter < adj.length; iter++)
      for (int here = 0; here < adj.length; here++)
        for (int i = 0; i < adj[here].size(); i++) {
          int there = adj[here].get(i).getNum();
          int cost = adj[here].get(i).getCost();
          upper[there] = Math.min(upper[there], upper[here] + cost);
        }
    for (int here = 0; here < adj.length; here++) {
      for (int i = 0; i < adj[here].size(); i++) {
        int there = adj[here].get(i).getNum();
        int cost = adj[here].get(i).getCost();
        if (upper[there] > upper[here] + cost) {
          if (reachable[start][here] && reachable[here][target])
            return MIN;
        }
      }
    }
    return upper[target];
  }

  private static int solve2(final int start, final int target, final ArrayList<WormHole>[] adj, int[] lower,
      boolean[][] reachable) {
    lower[start] = 0;
    for (int iter = 0; iter < adj.length; iter++)
      for (int here = 0; here < adj.length; here++)
        for (int i = 0; i < adj[here].size(); i++) {
          int there = adj[here].get(i).getNum();
          int cost = adj[here].get(i).getCost();
          lower[there] = Math.max(lower[there], lower[here] + cost);
        }
    for (int here = 0; here < adj.length; here++) {
      for (int i = 0; i < adj[here].size(); i++) {
        int there = adj[here].get(i).getNum();
        int cost = adj[here].get(i).getCost();
        if (lower[there] < lower[here] + cost) {
          if (reachable[start][here] && reachable[here][target])
            return MAX;
        }
      }
    }
    return lower[target];
  }

}
