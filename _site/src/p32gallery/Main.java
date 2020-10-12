package p32gallery;

import java.util.Scanner;

public class Main {

  private static int installed;
  private final static int UNWATCHED = 0;
  private final static int WATCHED = 1;
  private final static int INSTALLED = 2;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      int h = sc.nextInt();
      int[][] adj = new int[n][n];
      boolean[] visited = new boolean[n];
      for (int j = 0; j < h; j++)
        adj[sc.nextInt()][sc.nextInt()]++;
      System.out.println(installCamera(n, adj, visited));
    }
    sc.close();
  }

  private static int installCamera(int n, int[][] adj, boolean[] visited) {
    installed = 0;
    for (int i = 0; i < n; i++)
      if (!visited[i] && dfs(i, adj, visited) == UNWATCHED)
        installed++;
    return installed;
  }

  private static int dfs(int here, int[][] adj, boolean[] visited) {
    visited[here] = true;
    int[] children = { 0, 0, 0 };
    for (int there = 0; there < adj[here].length; there++)
      if ((adj[here][there] > 0 || adj[there][here] > 0) && !visited[there])
        children[dfs(there, adj, visited)]++;
    if (children[UNWATCHED] > 0) {
      installed++;
      return INSTALLED;
    }
    if (children[INSTALLED] > 0)
      return WATCHED;
    return UNWATCHED;
  }

}