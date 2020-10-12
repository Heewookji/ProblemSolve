package p37firetrucks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair> {

  private int num;
  private int cost;

  public Pair(int num, int cost) {
    this.num = num;
    this.cost = cost;
  }

  public int getCost() {
    return cost;
  }

  public int getNum() {
    return num;
  }

  @Override
  public int compareTo(Pair another) {
    return this.cost - another.cost;
  }

}

public class Main {

  final static int MAX = Integer.MAX_VALUE;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int spaceN = scanner.nextInt();
      int linkN = scanner.nextInt();
      int fireN = scanner.nextInt();
      int stationN = scanner.nextInt();
      ArrayList<Pair>[] adj = new ArrayList[spaceN + 1];
      for (int j = 0; j < adj.length; j++)
        adj[j] = new ArrayList<>();
      int[] fireArr = new int[fireN];
      int[] stationArr = new int[stationN];

      for (int j = 0; j < linkN; j++) {
        int one = scanner.nextInt();
        int another = scanner.nextInt();
        int cost = scanner.nextInt();
        adj[one].add(new Pair(another, cost));
        adj[another].add(new Pair(one, cost));
      }
      for (int j = 0; j < fireN; j++)
        fireArr[j] = scanner.nextInt();
      for (int j = 0; j < stationN; j++) {
        stationArr[j] = scanner.nextInt();
        adj[0].add(new Pair(stationArr[j], 0));
      }
      int ret = 0;
      int[] dist = dijikstra(0, adj);
      for (int j = 0; j < fireN; j++)
        ret += dist[fireArr[j]];
      System.out.println(ret);
    }

  }

  private static int[] dijikstra(int start, final ArrayList<Pair>[] adj) {
    int[] dist = new int[adj.length];
    PriorityQueue<Pair> pQueue = new PriorityQueue<>();
    Arrays.fill(dist, MAX);
    dist[start] = 0;
    pQueue.add(new Pair(start, 0));

    while (!pQueue.isEmpty()) {
      int here = pQueue.peek().getNum();
      int cost = pQueue.peek().getCost();
      pQueue.poll();
      if (cost > dist[here])
        continue;
      for (int i = 0; i < adj[here].size(); i++) {
        int there = adj[here].get(i).getNum();
        int nextCost = cost + adj[here].get(i).getCost();
        if (nextCost < dist[there]) {
          dist[there] = nextCost;
          pQueue.add(new Pair(there, nextCost));
        }
      }
    }

    return dist;
  }

}
