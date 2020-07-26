package p25traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      LinkedList<Integer> first = new LinkedList<>();
      LinkedList<Integer> second = new LinkedList<>();
      for (int j = 0; j < n; j++)
        first.offer(sc.nextInt());
      for (int j = 0; j < n; j++)
        second.offer(sc.nextInt());
      find(first, second);
      System.out.println();
    }
  }

  private static void find(List<Integer> first, List<Integer> second) {

    int n = first.size();
    if (first.isEmpty())
      return;
    int root = first.get(0);
    int leftSub = second.indexOf(root);
    find(first.subList(1, leftSub + 1), second.subList(0, leftSub));
    find(first.subList(leftSub + 1, n), second.subList(leftSub + 1, n));

    System.out.print(root + " ");
  }
}