package p41promises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int caseN = Integer.parseInt(br.readLine());
    int[][] adj;
    StringTokenizer st;
    for (int i = 0; i < caseN; i++) {
      st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(br.readLine());
      adj = new int[V][V];
      int M = Integer.parseInt(br.readLine());
      int N = Integer.parseInt(br.readLine());
      for (int j = 0; j < V; j++) {
        st = new StringTokenizer(br.readLine());
        int here = Integer.parseInt(br.readLine());
        int there = Integer.parseInt(br.readLine());
        int cost = Integer.parseInt(br.readLine());
        adj[here][there] = cost;
      }
    }
  }

}
