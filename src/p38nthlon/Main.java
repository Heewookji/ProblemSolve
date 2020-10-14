package p38nthlon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

import domain.Pair;


public class Main {

  final static int START = 401;
  final static int INF = Integer.MAX_VALUE;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();
    ArrayList<Pair<Integer>>[] adj = new ArrayList[START + 1];

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int j = 0; j < n; j++) {
        a[j] = scanner.nextInt();
        b[j] = scanner.nextInt();
      }
      init(adj, a, b);

      int[] dist = dijkstra(START, adj);
      int ret = dist[vertex(0)];
      System.out.println(ret == INF ? "IMPOSSIBLE" : ret);
    }
  }

  private static int[] dijkstra(final int start, final ArrayList<Pair<Integer>>[] adj) {

    int[] dist = new int[START + 1];
    Arrays.fill(dist, INF);
    PriorityQueue<Pair<Integer>> pQueue = new PriorityQueue<>();
    pQueue.add(new Pair<>(start, 0));

    while (!pQueue.isEmpty()) {
      int here = pQueue.peek().getNum();
      int nowCost = pQueue.peek().getCost();
      pQueue.poll();

      if (nowCost > dist[here])
        continue;

      for (int i = 0; i < adj[here].size(); i++) {
        int there = adj[here].get(i).getNum();
        int nextCost = nowCost + adj[here].get(i).getCost();
        if (nextCost < dist[there]) {
          dist[there] = nextCost;
          pQueue.add(new Pair<>(there, nextCost));
        }
      }
    }
    return dist;
  }

  private static void init(ArrayList<Pair<Integer>>[] adj, final int[] a, final int[] b) {
    for (int i = 0; i < adj.length; i++)
      adj[i] = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      int delta = a[i] - b[i];
      adj[START].add(new Pair<>(vertex(delta), a[i]));
    }
    for (int delta = -200; delta <= 200; delta++) {
      for (int i = 0; i < a.length; i++) {
        int next = delta + a[i] - b[i];
        if (Math.abs(next) > 200)
          continue;
        adj[vertex(delta)].add(new Pair<>(vertex(next), a[i]));
      }
    }
  }

  private static int vertex(int delta) {
    return delta + 200;
  }

}
