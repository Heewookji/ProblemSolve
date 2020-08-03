package p31wordchain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      sc.nextLine();
      String[] words = new String[n];
      for (int j = 0; j < n; j++)
        words[j] = sc.nextLine();

      System.out.println(solve(words));
    }
    sc.close();
  }

  private static String solve(final String[] words) {

    Stack<String>[][] graph = new Stack[26][26];

    int[][] adj = new int[26][26];
    int[] indegree = new int[26];
    int[] outdegree = new int[26];
    makeGraph(words, graph, adj, indegree, outdegree);

    if (!checkEuler(indegree, outdegree))
      return "IMPOSSIBLE";
    ArrayList<Integer> circuit = getEulerTrailOrCircuit(adj, indegree, outdegree);
    if (circuit.size() != words.length + 1)
      return "IMPOSSIBLE";

    Collections.reverse(circuit);
    String ret = "";
    for (int i = 1; i < circuit.size(); i++) {
      int a = circuit.get(i - 1), b = circuit.get(i);
      if (ret.length() > 0)
        ret += " ";
      ret += graph[a][b].pop();
    }
    return ret;
  }

  private static void makeGraph(final String[] words, Stack<String>[][] graph, int[][] adj, int[] indegree,
      int[] outdegree) {
    for (int i = 0; i < 26; i++)
      for (int j = 0; j < 26; j++)
        graph[i][j] = new Stack<String>();

    for (int i = 0; i < words.length; i++) {
      int first = words[i].charAt(0) - 'a';
      int last = words[i].charAt(words[i].length() - 1) - 'a';
      graph[first][last].push(words[i]);
      adj[first][last]++;
      outdegree[first]++;
      indegree[last]++;
    }
  }

  private static boolean checkEuler(int[] indegree, int[] outdegree) {

    int plus1 = 0, minus1 = 0;
    for (int i = 0; i < 26; i++) {
      int delta = outdegree[i] - indegree[i];
      if (delta < -1 || 1 < delta)
        return false;
      if (delta == 1)
        plus1++;
      if (delta == -1)
        minus1++;
    }
    return (plus1 == 1 && minus1 == 1) || (plus1 == 0 && minus1 == 0);
  }

  private static void getEulerCircuit(int here, int[][] adj, ArrayList<Integer> circuit) {
    for (int there = 0; there < adj.length; there++) {
      while (adj[here][there] > 0) {
        adj[here][there]--;
        getEulerCircuit(there, adj, circuit);
      }
    }
    circuit.add(here);
  }

  private static ArrayList<Integer> getEulerTrailOrCircuit(int[][] adj, int[] indegree, int[] outdegree) {
    ArrayList<Integer> circuit = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      if (outdegree[i] == indegree[i] + 1) {
        getEulerCircuit(i, adj, circuit);
        return circuit;
      }
    }
    for (int i = 0; i < 26; i++) {
      if (outdegree[i] > 0) {
        getEulerCircuit(i, adj, circuit);
        return circuit;
      }
    }
    return circuit;
  }

}