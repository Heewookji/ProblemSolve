package p34sortgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    HashMap<List<Integer>, Integer> toSort = new HashMap<>();
    for (int i = 1; i <= 8; i++)
      precalc(toSort, i);

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      List<Integer> perm = new ArrayList<>();
      for (int j = 0; j < n; j++)
        perm.add(scanner.nextInt());
      System.out.println(solve(perm, toSort));
    }
    scanner.close();
  }

  private static HashMap<List<Integer>, Integer> precalc(HashMap<List<Integer>, Integer> toSort, int n) {

    List<Integer> perm = new ArrayList<>();
    for (int i = 0; i < n; i++)
      perm.add(i);
    Queue<List<Integer>> que = new LinkedList<>();
    que.add(perm);
    toSort.put(perm, 0);

    while (!que.isEmpty()) {
      List<Integer> here = que.poll();
      int cost = toSort.get(here);
      for (int i = 0; i < n; i++) {
        for (int j = i + 2; j <= n; j++) {
          List<Integer> there = new ArrayList<>(here);
          Collections.reverse(there.subList(i, j));
          if (!toSort.containsKey(there)) {
            toSort.put(there, cost + 1);
            que.add(there);
          }
        }
      }
    }
    return toSort;
  }

  private static int solve(final List<Integer> perm, final HashMap<List<Integer>, Integer> toSort) {
    int n = perm.size();
    List<Integer> fixed = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int smallerCount = 0;
      for (int j = 0; j < n; j++)
        if (perm.get(j) < perm.get(i))
          smallerCount++;
      fixed.add(i, smallerCount);
    }
    return toSort.get(fixed);
  }

}