package p19asymtiling;

import java.util.Scanner;

public class Main4 {

  final static int MOD = 1000000007;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      int[] cache = new int[n + 1];
      System.out.println((tiling(n, cache) - find(n, cache) + MOD) % MOD);
    }
  }

  private static int tiling(int n, int[] cache) {
    if (n <= 1)
      return 1;
    if (cache[n] != 0)
      return cache[n];
    return cache[n] = (tiling(n - 1, cache) + tiling(n - 2, cache)) % MOD;
  }

  private static int find(int n, int[] cache) {
    if (n % 2 == 1)
      return tiling(n / 2, cache);
    else
      return (tiling(n / 2, cache) + tiling(n / 2 - 1, cache)) % MOD;
  }

}
