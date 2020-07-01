package p21numb3rs;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {

      int n = sc.nextInt();
      int day = sc.nextInt();
      int jail = sc.nextInt();
      int[][] link = new int[n][n];

      for (int y = 0; y < n; y++)
        for (int x = 0; x < n; x++)
          link[y][x] = sc.nextInt();
      int retN = sc.nextInt();
      double[][] cache = new double[day + 1][n];

      for (int r = 0; r < retN; r++) {
        for (int c = 0; c < cache.length; c++)
          Arrays.fill(cache[c], -1);
        System.out.println(recursive(day, jail, link, sc.nextInt(), cache));
      }

    }
  }

  public static double recursive(int day, int now, final int[][] link, int target, double[][] cache) {

    if (day == 0)
      return now == target ? 1 : 0;
    if (cache[day][now] != -1)
      return cache[day][now];
    double ret = 0;
    double count = 0;
    for (int next = 0; next < link.length; next++) {
      if (link[now][next] == 1) {
        count++;
        ret += recursive(day - 1, next, link, target, cache);
      }
    }
    ret *= 1 / count;

    return cache[day][now] = ret;
  }
}
