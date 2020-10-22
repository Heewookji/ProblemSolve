package p41promises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  final static int MAX = 1000000;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseN = Integer.parseInt(br.readLine());
    int[][] adj;
    StringTokenizer st;
    for (int i = 0; i < caseN; i++) {
      st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      adj = new int[V][V];
      for (int j = 0; j < V; j++)
        Arrays.fill(adj[j], MAX);
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      for (int j = 0; j < M; j++)
        inputArr(adj, new StringTokenizer(br.readLine()));

      floyd(adj, V);
      int count = 0;
      for (int j = 0; j < N; j++)
        if (!isUseful(adj, V, new StringTokenizer(br.readLine())))
          count++;
      System.out.println(count);
    }
  }

  // 간선 추가 (V제곱)
  private static boolean isUseful(int[][] adj, int N, StringTokenizer st) {
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    if (adj[a][b] <= c)
      return false;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        adj[i][j] = Math.min(adj[i][j], Math.min(adj[i][a] + c + adj[b][j], adj[i][b] + c + adj[a][j]));
    return true;
  }

  private static void floyd(int[][] adj, int N) {
    for (int i = 0; i < N; i++)
      adj[i][i] = 0;
    for (int k = 0; k < N; k++)
      for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
          adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
  }

  private static void inputArr(int[][] adj, StringTokenizer st) {
    int here = Integer.parseInt(st.nextToken());
    int there = Integer.parseInt(st.nextToken());
    int cost = Integer.parseInt(st.nextToken());
    if (adj[here][there] < cost)
      return;
    adj[here][there] = cost;
    adj[there][here] = cost;
  }

}
