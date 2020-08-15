package p34sortgame;

import java.util.Arrays;
import java.util.LinkedHashMap;
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
    int caseN = scanner.nextInt();

    for (int i = 0; i < caseN; i++) {
      int n = scanner.nextInt();
      int[] list = new int[n];
      for (int j = 0; j < n; j++)
        list[j] = scanner.nextInt();
      System.out.println(bfs(new ArrayWrapper(list), list.length));
    }
    scanner.close();
  }

  private static int bfs(ArrayWrapper list, int n) {

    ArrayWrapper sorted = new ArrayWrapper(list.getList().clone());
    Arrays.sort(sorted.getList());
    Queue<ArrayWrapper> que = new LinkedList<>();
    LinkedHashMap<ArrayWrapper, Integer> distance = new LinkedHashMap<>();
    distance.put(list, 0);
    que.add(list);

    while (!que.isEmpty()) {
      ArrayWrapper here = que.poll();
      int cost = distance.get(here);
      if (here.equals(sorted))
        return cost;
      for (int i = 0; i < n; i++) {
        for (int j = i + 2; j <= n; j++) {
          ArrayWrapper there = reverse(here, i, j);
          if (!distance.containsKey(there)) {
            distance.put(there, cost + 1);
            que.add(there);
          }
        }
      }
    }
    return -1;
  }

  private static ArrayWrapper reverse(ArrayWrapper array, int start, int end) {
    int[] newArray = array.getList().clone();
    for (int point = start; point - start < (end - start) / 2; point++) {
      int temp = newArray[point];
      newArray[point] = newArray[end - (point - start) - 1];
      newArray[end - (point - start) - 1] = temp;
    }
    return new ArrayWrapper(newArray);
  }

}