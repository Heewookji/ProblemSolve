package p34sortgame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      int[] list = new int[n];
      for (int j = 0; j < n; j++)
        list[j] = scanner.nextInt();
      System.out.println(bfs(list));
    }
    scanner.close();
  }

  private static int bfs(int[] list) {

    int n = list.length;
    int[] sorted = new int[n];
    Arrays.sort(sorted);
    Queue<int[]> que = new LinkedList<>();
    Map<int[], Integer> distance = new HashMap<>();
    distance.put(list, 0);
    que.add(list);

    while (!que.isEmpty()) {
      int[] here = que.poll();
      int cost = distance.get(here);
      if (here.equals(sorted))
        return cost;
      for (int i = 0; i < n; i++) {
        for (int j = i + 2; j < n; j++) {
          int[] there = null; // reverse(here)
          if (distance.get(there) == 0) {
            distance.put(there, cost + 1);
            que.add(there);
          }
          // reverse
        }
      }
    }
    return -1;

  }

}