package p17tripathcnt;

import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {

      int n = sc.nextInt();
      int[][] triangle = new int[n][n];
      int[][] cache = new int[n][n];
      int[][] countCache = new int[n][n];
      for (int y = 0; y < n; y++)
        for (int x = 0; x <= y; x++)
          triangle[y][x] = sc.nextInt();
      recursive(triangle, 0, 0, cache);
      System.out.println(findCount(cache, 0, 0, countCache));
    }
  }

  private static int recursive(int[][] triangle, int x, int y, int[][] cache) {

    if (y == triangle.length - 1)
      return cache[y][x] = triangle[y][x];

    if (cache[y][x] != 0)
      return cache[y][x];

    return cache[y][x] = triangle[y][x]
        + Math.max(recursive(triangle, x, y + 1, cache), recursive(triangle, x + 1, y + 1, cache));
  }

  private static int findCount(int[][] cache, int x, int y, int[][] countCache) {

    if (y == cache.length - 1)
      return 1;
    if (countCache[y][x] != 0)
      return countCache[y][x];

    int ret = 0;
    if (cache[y + 1][x] >= cache[y + 1][x + 1])
      ret += findCount(cache, x, y + 1, countCache);
    if (cache[y + 1][x] <= cache[y + 1][x + 1])
      ret += findCount(cache, x + 1, y + 1, countCache);

    return countCache[y][x] = ret;
  }

}
