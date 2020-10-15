package common.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 정점  간선
 * 5    9    0 1 2    0 2 12    1 0 2    1 3 4    2 0 12    2 3 3    3 1 4    3 2 3   4 4 2
 * 
 * 
 **/

public class Floyd {

  public final static int MAX = 1000000;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int start = 0;
    int end = 4;
    int[][] adj = new int[n][n];
    int[][] via = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(adj[i], MAX);
      Arrays.fill(via[i], -1);
    }

    int linkN = scanner.nextInt();
    for (int j = 0; j < linkN; j++)
      adj[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
    int[][][] c = new int[n][n][n];
    int[][][] c2 = new int[2][n][n];

    solution1(adj, c, n);
    System.out.println(c[n - 1][start][end]);
    solution2(adj, c2, n);
    System.out.println(c[n - 1][start][end]);
    solution3(adj, n, via);
    System.out.println(adj[start][end]);
    System.out.println("--------------------");
    ArrayList<Integer> path = new ArrayList<>();
    reconstruct(start, end, via, path);
    for (int i = 0; i < path.size(); i++)
      System.out.println(path.get(i));
  }

  public static void solution1(int[][] adj, int[][][] c, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j)
          c[0][i][j] = Math.min(adj[i][j], adj[i][0] + adj[0][j]);
        else
          c[0][i][j] = 0;
      }
    }
    for (int k = 1; k < n; k++)
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          c[k][i][j] = Math.min(c[k - 1][i][j], c[k - 1][i][k] + c[k - 1][k][j]);
  }

  public static void solution2(int[][] adj, int[][][] c, int n) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j)
          c[0][i][j] = Math.min(adj[i][j], adj[i][0] + adj[0][j]);
        else
          c[0][i][j] = 0;
      }
    }
    for (int k = 1; k < n; k++)
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          c[k % 2][i][j] = Math.min(c[(k - 1) % 2][i][j], c[(k - 1) % 2][i][k] + c[(k - 1) % 2][k][j]);
  }

  public static void solution3(int[][] adj, int n, int[][] via) {
    for (int i = 0; i < n; i++)
      adj[i][i] = 0;
    for (int k = 0; k < n; k++)
      for (int i = 0; i < n; i++) {
        if (adj[i][k] == MAX)
          continue;
        for (int j = 0; j < n; j++)
          if (adj[i][j] > adj[i][k] + adj[k][j]) {
            adj[i][j] = adj[i][k] + adj[k][j];
            via[i][j] = k;
          }
      }
  }

  public static void reconstruct(int start, int end, final int[][] via, ArrayList<Integer> path) {

    if (via[start][end] == -1) {
      path.add(start);
      if (start != end)
        path.add(end);
    } else {
      int middle = via[start][end];
      reconstruct(start, middle, via, path);
      path.remove(path.size() - 1);
      reconstruct(middle, end, via, path);
    }
  }

}
