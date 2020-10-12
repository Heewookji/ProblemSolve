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
      int[] deg = new int[n];

      for (int y = 0; y < n; y++) {
        int count = 0;
        for (int x = 0; x < n; x++) {
          link[y][x] = sc.nextInt();
          if (link[y][x] == 1)
            count++;
        }
        deg[y] = count;
      }

      int retN = sc.nextInt();
      double[][] cache = new double[day + 1][n];
      for (int c = 0; c < cache.length; c++)
        Arrays.fill(cache[c], -1);
      for (int r = 0; r < retN; r++)
        System.out.println(recursive(day, sc.nextInt(), link, jail, cache, deg));
    }
  }

  public static double recursive(int day, int now, final int[][] link, int target, double[][] cache, int[] deg) {

    if (day == 0)
      return now == target ? 1 : 0;
    if (cache[day][now] != -1)
      return cache[day][now];

    double ret = 0;
    for (int past = 0; past < link.length; past++)
      if (link[now][past] == 1)
        ret += recursive(day - 1, past, link, target, cache, deg) / deg[past];

    return cache[day][now] = ret;
  }
}
