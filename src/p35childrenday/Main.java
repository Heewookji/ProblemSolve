package p35childrenday;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {

  private int parent = -1;
  private int choice = -1;

  public int getParent() {
    return this.parent;
  }

  public int getChoice() {
    return this.choice;
  }

  public void setParent(int parent) {
    this.parent = parent;
  }

  public void setChoice(int choice) {
    this.choice = choice;
  }

}

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();
    for (int i = 0; i < caseN; i++) {
      String numbers = scanner.next();
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      Pair[] graph = makeGraph(numbers, n, m);
      System.out.println(solve(n, m, graph));
    }
    scanner.close();
  }

  private static String solve(int n, int m, Pair[] graph) {

    String ret = "";
    int target = n + m;
    if (graph[target].getParent() == -1)
      return "IMPOSSIBLE";
    while (graph[target].getParent() != target) {
      ret = (char) (graph[target].getChoice() + '0') + ret;
      target = graph[target].getParent();
    }
    return ret;
  }

  private static Pair[] makeGraph(String number, int n, int m) {

    String[] numbers = number.split("");
    Arrays.sort(numbers);
    number = String.join("", numbers);
    Pair[] graph = new Pair[2 * n];
    for (int i = 0; i < graph.length; i++)
      graph[i] = new Pair();
    Queue<Integer> que = new LinkedList<>();
    graph[0].setParent(0);
    que.add(0);

    while (!que.isEmpty()) {
      int here = que.poll();
      for (int i = 0; i < number.length(); i++) {
        int there = append(here, number.charAt(i) - '0', n);
        if (graph[there].getParent() == -1) {
          graph[there].setParent(here);
          graph[there].setChoice(number.charAt(i) - '0');
          que.add(there);
        }
      }
    }
    return graph;
  }

  private static int append(int here, int next, int mod) {
    int there = here * 10 + next;
    if (there >= mod)
      return mod + there % mod;
    return there % mod;
  }

}