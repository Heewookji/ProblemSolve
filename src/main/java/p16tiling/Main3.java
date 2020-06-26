package p16tiling;

import java.util.Scanner;

public class Main3 {

  static final int MOD = 1000000007;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      System.out.println(recursive(n, new int[n + 1]));
    }
  }

  private static int recursive(int n, int[] cache) {

    if (n == 1 || n == 2)
      return n;
    if (cache[n] != 0)
      return cache[n];

    return cache[n] = (recursive(n - 1, cache) + recursive(n - 2, cache)) % MOD;
  }
}
