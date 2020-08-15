package p34sortgame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class ArrayWrapper {

  private int[] list;

  public ArrayWrapper(int[] list) {
    this.list = list;
  }

  @Override
  public boolean equals(Object obj) {
    ArrayWrapper another = (ArrayWrapper) obj;
    return Arrays.equals(this.getList(), another.getList());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int hashCode = 1;
    String line = "";
    for (int i : list)
      line += String.valueOf(i);
    hashCode = prime * hashCode + line.hashCode();
    return hashCode;
  }

  public int[] getList() {
    return this.list;
  }

}

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    HashMap<ArrayWrapper, Integer> toSort = precalc(8);
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      int[] perm = new int[n];
      for (int j = 0; j < n; j++)
        perm[j] = scanner.nextInt();
      System.out.println(solve(perm, toSort));
    }
    scanner.close();
  }

  private static HashMap<ArrayWrapper, Integer> precalc(int n) {

    HashMap<ArrayWrapper, Integer> toSort = new HashMap<>();
    int[] array = new int[n];
    for (int i = 0; i < n; i++)
      array[i] = i;
    ArrayWrapper perm = new ArrayWrapper(array);
    Queue<ArrayWrapper> que = new LinkedList<>();
    que.add(perm);
    toSort.put(perm, 0);

    while (!que.isEmpty()) {
      ArrayWrapper here = que.poll();
      int cost = toSort.get(here);
      for (int i = 0; i < n; i++) {
        for (int j = i + 2; j <= n; j++) {
          ArrayWrapper there = reverse(here, i, j);
          if (!toSort.containsKey(there)) {
            toSort.put(there, cost + 1);
            que.add(there);
          }
        }
      }
    }
    return toSort;
  }

  private static ArrayWrapper reverse(final ArrayWrapper array, int start, int end) {
    int[] newArray = array.getList().clone();
    for (int point = start; point - start < (end - start) / 2; point++) {
      int temp = newArray[point];
      newArray[point] = newArray[end - (point - start) - 1];
      newArray[end - (point - start) - 1] = temp;
    }
    return new ArrayWrapper(newArray);
  }

  private static int solve(final int[] perm, final HashMap<ArrayWrapper, Integer> toSort) {
    int n = perm.length;
    int[] fixed = new int[8];

    for (int i = 0; i < 8; i++)
      fixed[i] = i;
    for (int i = 0; i < n; i++) {
      int smallerCount = 0;
      for (int j = 0; j < n; j++)
        if (perm[j] < perm[i])
          smallerCount++;
      fixed[i] = smallerCount;
    }
    
    return toSort.get(new ArrayWrapper(fixed));
  }

}