package p40drunkendriving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

  final static int MAX = 1000;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    ArrayList<Pair<Integer>> inspect = new ArrayList<>();
    int[][] adj = new int[V + 1][V + 1];
    int[][] w = new int[V + 1][V + 1];
    st = new StringTokenizer(br.readLine());
    inspect.add(new Pair<>(0, MAX));
    for (int i = 1; i < V + 1; i++) {
      inspect.add(new Pair<>(i, Integer.parseInt(st.nextToken())));
      Arrays.fill(adj[i], MAX);
      adj[i][i] = 0;
    }
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int here = Integer.parseInt(st.nextToken());
      int there = Integer.parseInt(st.nextToken());
      int delay = Integer.parseInt(st.nextToken());
      adj[here][there] = delay;
      adj[there][here] = delay;
    }

    floyd(adj, w, inspect, V);

    st = new StringTokenizer(br.readLine());
    int caseN = Integer.parseInt(st.nextToken());

    for (int i = 0; i < caseN; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      System.out.println(w[start][end]);
    }
  }

  private static void floyd(int[][] adj, int[][] w, final ArrayList<Pair<Integer>> inspect, final int V) {
    
    Collections.sort(inspect);
    // 정점을 하나도 거치지 않는 최단경로
    for (int i = 0; i < V + 1; i++)
      for (int j = 0; j < V + 1; j++)
        if (i == j)
          w[i][j] = 0;
        else
          w[i][j] = adj[i][j];

    for (int z = 0; z < V; z++) {
      // 가장 적은 소요시간 정점부터
      int k = inspect.get(z).getNum();
      int delay = inspect.get(z).getCost();
      for (int i = 1; i < V + 1; i++)
        for (int j = 1; j < V + 1; j++) {
          adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
          w[i][j] = Math.min(w[i][j], adj[i][k] + delay + adj[k][j]);
        }
    }
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

