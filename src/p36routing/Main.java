package p36routing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import domain.Pair;


public class Main {

  final static double MAX = Math.pow(10, 200);

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseN = Integer.valueOf(br.readLine());

    for (int i = 0; i < caseN; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int linkN = Integer.parseInt(st.nextToken());

      ArrayList<Pair<Double>> adj[] = new ArrayList[n];
      double[] dist = new double[n];
      Arrays.fill(dist, MAX);
      for (int j = 0; j < adj.length; j++)
        adj[j] = new ArrayList<>();
      for (int j = 0; j < linkN; j++) {
        st = new StringTokenizer(br.readLine());
        int here = Integer.parseInt(st.nextToken());
        int there = Integer.parseInt(st.nextToken());
        double noise = Double.parseDouble(st.nextToken());
        adj[here].add(new Pair<>(there, noise));
        adj[there].add(new Pair<>(here, noise));
      }
      dijkstra(adj, dist);
      System.out.printf("%.10f\n", dist[n - 1]);
    }
  }

  private static void dijkstra(ArrayList<Pair<Double>>[] adj, double[] dist) {
    PriorityQueue<Pair<Double>> pQueue = new PriorityQueue<>();
    dist[0] = 1;
    pQueue.add(new Pair<>(0, 1.0));

    while (!pQueue.isEmpty()) {
      int here = pQueue.peek().getNum();
      double nowCost = pQueue.peek().getCost();
      pQueue.poll();

      if (nowCost > dist[here])
        continue;

      for (int i = 0; i < adj[here].size(); i++) {
        int there = adj[here].get(i).getNum();
        double nextCost = nowCost * adj[here].get(i).getCost();
        if (nextCost < dist[there]) {
          pQueue.add(new Pair<>(there, nextCost));
          dist[there] = nextCost;
        }
      }
    }
  }

}
