package p12lis;

import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {

      int n = sc.nextInt();
      int[] list = new int[n];
      int[] cache = new int[n];

      for (int j = 0; j < n; j++)
        list[j] = sc.nextInt();

      int ret = 0;
      for (int j = 0; j < n; j++)
        ret = Math.max(ret, recursive(list, j, cache));

      System.out.println(ret);
    }
  }

  private static int recursive(int[] list, int index, int[] cache) {

    if (cache[index] != 0)
      return cache[index];

    int ret = 1;
    for (int nextIndex = index + 1; nextIndex < list.length; nextIndex++) {
      if (list[index] < list[nextIndex])
        ret = Math.max(ret, 1 + recursive(list, nextIndex, cache));
    }
    return cache[index] = ret;
  }
}
