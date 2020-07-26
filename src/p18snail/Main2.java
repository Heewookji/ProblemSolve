package p18snail;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {

      int n = sc.nextInt();
      int m = sc.nextInt();

      double[][] cache = new double[n + 1][m + 1];
      for (double[] d : cache)
        Arrays.fill(d, -1);
      System.out.println(recursive(n, m, cache));

    }
  }

  private static double recursive(int nowDepth, int nowDay, double[][] cache) {

    if (nowDepth <= 0)
      return 1;
    if (nowDay == 0)
      return 0;

    if (cache[nowDepth][nowDay] != -1)
      return cache[nowDepth][nowDay];

    return cache[nowDepth][nowDay] = 0.75 * recursive(nowDepth - 2, nowDay - 1, cache)
        + 0.25 * recursive(nowDepth - 1, nowDay - 1, cache);
  }

}
