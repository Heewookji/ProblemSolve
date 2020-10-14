package p39timetrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

  final static int INF = 987654321;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      int w = scanner.nextInt();
      ArrayList<Pair<Integer>>[] adj = new ArrayList[n];
      boolean[][] reachable = new boolean[n][n];
      for (int j = 0; j < n; j++)
        adj[j] = new ArrayList<>();

      for (int j = 0; j < w; j++) {
        int here = scanner.nextInt();
        int there = scanner.nextInt();
        int cost = scanner.nextInt();
        adj[here].add(new Pair<>(there, cost));
        reachable[here][there] = true;
      }

      Floyd.solution3(reachable, n);

      int ret1 = solve(0, 1, adj, reachable);

      for (int j = 0; j < n; j++)
        for (Pair<Integer> hole : adj[j])
          hole.setCost(-hole.getCost());

      int ret2 = solve(0, 1, adj, reachable);

      if (ret1 == INF)
        System.out.println("UNREACHABLE");
      else
        System.out.println((ret1 == -INF ? "INFINITY" : ret1) + " " + (ret2 == -INF ? "INFINITY" : -ret2));
    }
  }

  private static int solve(final int start, final int target, final ArrayList<Pair<Integer>>[] adj,
      final boolean[][] reachable) {

    int[] upper = new int[adj.length];
    Arrays.fill(upper, INF);
    upper[start] = 0;
    for (int iter = 0; iter < adj.length - 1; iter++)
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
            return -INF;
        }
      }
    }
    if (!reachable[start][target] && upper[target] != INF)
      return INF;
    return upper[target];
  }
}

class Floyd {

  public static boolean[][] solution3(boolean[][] reachable, int n) {
    for (int i = 0; i < n; i++)
      reachable[i][i] = true;
    for (int k = 0; k < n; k++)
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          reachable[i][j] |= reachable[i][k] && reachable[k][j];
    return reachable;
  }
}

class Pair<E extends Comparable<E>> implements Comparable<Pair<E>> {
  private int num;
  private E cost;

  public Pair(int num, E cost) {
    this.num = num;
    this.cost = cost;
  }

  public E getCost() {
    return cost;
  }

  public int getNum() {
    return num;
  }

  public void setCost(E cost) {
    this.cost = cost;
  }

  @Override
  public int compareTo(Pair<E> another) {
    return this.cost.compareTo(another.cost);
  }
}
