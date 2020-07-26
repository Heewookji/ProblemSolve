package p13jlis;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static int[] A;
  static int[] B;
  static int n;
  static int m;
  static int[][] cache = new int[101][101];
  static final long MIN = Long.MIN_VALUE;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int t = 0; t < testN; t++) {

      n = sc.nextInt();
      m = sc.nextInt();
      A = new int[n];
      for (int i = 0; i < n; i++)
        A[i] = sc.nextInt();
      B = new int[m];
      for (int i = 0; i < m; i++)
        B[i] = sc.nextInt();
      for (int i = 0; i < 101; i++)
        Arrays.fill(cache[i], -1);

      System.out.println(find(-1, -1) - 2);
    }
  }

  private static int find(int indexA, int indexB) {

    if (cache[indexA + 1][indexB + 1] != -1)
      return cache[indexA + 1][indexB + 1];

    int ret = 2;
    long a = (indexA == -1 ? MIN : A[indexA]);
    long b = (indexB == -1 ? MIN : B[indexB]);
    long maxElement = Math.max(a, b);
    for (int nextA = indexA + 1; nextA < n; nextA++) {
      if (maxElement < A[nextA])
        ret = Math.max(ret, find(nextA, indexB) + 1);
    }
    for (int nextB = indexB + 1; nextB < m; nextB++) {
      if (maxElement < B[nextB])
        ret = Math.max(ret, find(indexA, nextB) + 1);
    }
    return cache[indexA + 1][indexB + 1] = ret;
  }
}
