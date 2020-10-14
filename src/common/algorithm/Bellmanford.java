package common.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import domain.Pair;

/**
 * 
 * 4 8 0 1 2 0 2 12 1 0 2 1 3 4 2 0 12 2 3 3 3 1 4 3 2 3
 * 
 * 
 **/

public class Bellmanford {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    ArrayList<Pair<Integer>>[] adj = new ArrayList[n];
    for (int i = 0; i < adj.length; i++)
      adj[i] = new ArrayList<Pair<Integer>>();
    int linkN = scanner.nextInt();
    for (int j = 0; j < linkN; j++)
      adj[scanner.nextInt()].add(new Pair<>(scanner.nextInt(), scanner.nextInt()));

    int[] ret = solve(adj, 0);
    System.out.println(ret[2]);
  }

  public static int[] solve(final ArrayList<Pair<Integer>>[] adj, final int start) {
    int[] upper = new int[adj.length];
    Arrays.fill(upper, Integer.MAX_VALUE);
    upper[start] = 0;
    boolean updated = false;

    for (int iter = 0; iter < adj.length; iter++) {
      updated = false;
      for (int here = 0; here < adj.length; here++) {
        for (int i = 0; i < adj[here].size(); i++) {
          int there = adj[here].get(i).getNum();
          int cost = adj[here].get(i).getCost();
          if (upper[there] > upper[here] + cost) {
            upper[there] = upper[here] + cost;
            updated = true;
          }
        }
      }
      if (!updated)
        break;
    }
    if (updated)
      return new int[0];
    return upper;
  }

}
