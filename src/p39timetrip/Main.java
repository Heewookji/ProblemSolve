package p39timetrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import common.algorithm.Floyd;
import domain.Pair;

public class Main {

  final static int MAX = Integer.MAX_VALUE;
  final static int MIN = Integer.MIN_VALUE;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      int w = scanner.nextInt();
      ArrayList<Pair<Integer>>[] adj = new ArrayList[n];
      int[][] adjForFloyd = new int[n][n];
      for (int j = 0; j < n; j++)
        adj[j] = new ArrayList<>();
      for (int j = 0; j < w; j++) {
        int here = scanner.nextInt();
        int there = scanner.nextInt();
        int cost = scanner.nextInt();
        adj[here].add(new Pair<>(there, cost));
        adjForFloyd[here][there] = cost;
      }
      int[] upper = new int[n];
      int[] lower = new int[n];
      Arrays.fill(upper, MAX);
      Arrays.fill(lower, MAX);
      Floyd.solution3(adjForFloyd, n);

      int ret1 = solve(0, 1, adj, upper, adjForFloyd);

      for (int j = 0; j < n; j++)
        for (Pair<Integer> hole : adj[j])
          hole.setCost(-hole.getCost());

      int ret2 = solve(0, 1, adj, lower, adjForFloyd);

      if (ret1 == MAX)
        System.out.println("UNREACHABLE");
      else
        System.out.println((ret1 == MIN ? "INFINITY" : ret1) + " " + (ret2 == MIN ? "INFINITY" : -ret2));
    }
  }

  private static int solve(final int start, final int target, final ArrayList<Pair<Integer>>[] adj, int[] upper,
      int[][] reachable) {
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
          if (reachable[start][here] < Floyd.MAX && reachable[here][target] < Floyd.MAX)
            return MIN;
        }
      }
    }
    return upper[target];
  }

}
