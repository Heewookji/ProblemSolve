package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
  int num;
  int cost;

  public Pair(int num, int cost) {
    this.num = num;
    this.cost = cost;
  }

  @Override
  public int compareTo(Pair another) {
    return this.cost - another.cost;
  }
}

/**
 * 
 * 4 8 0 1 2 0 2 12 1 0 2 1 3 4 2 0 12 2 3 3 3 1 4 3 2 3
 * 
 * 
 **/

public class Dijkstra {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    ArrayList<Pair>[] adj = new ArrayList[n];
    for (int i = 0; i < adj.length; i++)
      adj[i] = new ArrayList<Pair>();
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    int linkN = scanner.nextInt();
    for (int j = 0; j < linkN; j++)
      adj[scanner.nextInt()].add(new Pair(scanner.nextInt(), scanner.nextInt()));

    new Dijkstra().DoWithoutQueue(0, adj, dist);
    System.out.println(dist[2]);
  }

  private void Do(int start, ArrayList<Pair>[] adj, int[] dist) {
    PriorityQueue<Pair> pQueue = new PriorityQueue<>();
    pQueue.offer(new Pair(start, 0));
    dist[start] = 0;

    while (!pQueue.isEmpty()) {
      int here = pQueue.peek().num;
      int nowTotalCost = pQueue.peek().cost;
      pQueue.poll();
      if (dist[here] < nowTotalCost)
        continue;

      for (int i = 0; i < adj[here].size(); i++) {
        int there = adj[here].get(i).num;
        int nextTotalCost = nowTotalCost + adj[here].get(i).cost;
        if (dist[there] > nextTotalCost) {
          dist[there] = nextTotalCost;
          pQueue.offer(new Pair(there, nextTotalCost));
        }
      }

    }
  }

  private void DoWithoutQueue(int start, ArrayList<Pair>[] adj, int[] dist) {

    boolean[] visited = new boolean[dist.length];
    int here = -1;
    int closest;
    dist[start] = 0;
    while (true) {
      closest = Integer.MAX_VALUE;
      for (int i = 0; i < adj.length; i++) {
        if (!visited[i] && closest > dist[i]) {
          here = i;
          closest = dist[i];
        }
      }
      if (closest == Integer.MAX_VALUE)
        break;
      visited[here] = true;
      for (int i = 0; i < adj[here].size(); i++) {
        int there = adj[here].get(i).num;
        if (visited[there])
          continue;
        int cost = adj[here].get(i).cost;
        dist[there] = Math.min(dist[there], cost + dist[here]);
      }
    }

  }

}
