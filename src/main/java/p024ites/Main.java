package p024ites;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {

      int target = sc.nextInt();
      int n = sc.nextInt();
      long[] list = new long[n];
      list[0] = 1983;
      long seed = list[0];
      for (int l = 0; l < list.length; l++) {
        list[l] = seed % 10000 + 1;
        seed = (seed * 214013 + 2531011) % (long) Math.pow(2, 32);
      }
      for (int l = 0; l < list.length; l++)
        System.out.println(list[l]);

      System.out.println(find(list, target));

    }

  }

  private static int find(final long[] list, int target) {

    int ret = 0;
    for (int i = 0; i < list.length; i++) {
      int sum = 0;
      for (int j = i; j < list.length; j++) {
        sum += list[j];
        if (sum == target)
          ret++;
        if (sum >= target)
          break;
      }
    }
    return ret;
  }

}