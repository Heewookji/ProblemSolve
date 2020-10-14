package common.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

import domain.Pair;


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
    ArrayList<Pair<Integer>>[] adj = new ArrayList[n];
    for (int i = 0; i < adj.length; i++)
      adj[i] = new ArrayList<Pair<Integer>>();
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    int linkN = scanner.nextInt();
    for (int j = 0; j < linkN; j++)
      adj[scanner.nextInt()].add(new Pair<>(scanner.nextInt(), scanner.nextInt()));

    doWithoutQueue(0, adj, dist);
    System.out.println(dist[2]);
  }

  public static void doWithQueue(int start, ArrayList<Pair<Integer>>[] adj, int[] dist) {
    PriorityQueue<Pair<Integer>> pQueue = new PriorityQueue<>();
    pQueue.offer(new Pair<>(start, 0));
    dist[start] = 0;

    while (!pQueue.isEmpty()) {
      int here = pQueue.peek().getNum();
      int nowTotalCost = pQueue.peek().getCost();
      pQueue.poll();
      if (dist[here] < nowTotalCost)
        continue;

      for (int i = 0; i < adj[here].size(); i++) {
        int there = adj[here].get(i).getNum();
        int nextTotalCost = nowTotalCost + adj[here].get(i).getCost();
        if (dist[there] > nextTotalCost) {
          dist[there] = nextTotalCost;
          pQueue.offer(new Pair<>(there, nextTotalCost));
        }
      }
    }
  }

  public static void doWithoutQueue(int start, ArrayList<Pair<Integer>>[] adj, int[] dist) {

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
        int there = adj[here].get(i).getNum();
        if (visited[there])
          continue;
        int cost = adj[here].get(i).getCost();
        dist[there] = Math.min(dist[there], cost + dist[here]);
      }
    }

  }

}
