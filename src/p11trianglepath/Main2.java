package p11trianglepath;

import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {

      int n = sc.nextInt();
      int[][] triangle = new int[n][n];
      int[][] cache = new int[n][n];

      for (int y = 0; y < n; y++)
        for (int x = 0; x <= y; x++)
          triangle[y][x] = sc.nextInt();

      System.out.println(recursive(triangle, 0, 0, cache));
    }
  }

  private static int recursive(int[][] triangle, int x, int y, int[][] cache) {

    if (y == triangle.length - 1)
      return triangle[y][x];

    if (cache[y][x] != 0)
      return cache[y][x];

    return cache[y][x] = triangle[y][x]
        + Math.max(recursive(triangle, x, y + 1, cache), recursive(triangle, x + 1, y + 1, cache));
  }

}
