package p19asymtiling;

import java.util.Scanner;

public class Main3 {

  static final int MOD = 1000000007;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      int[] cache = new int[n + 1];
      System.out.println((recursive(n, cache) - calculate(n, cache) + MOD) % MOD);
    }

  }

  private static int recursive(int n, int[] cache) {

    if (n <= 1)
      return 1;
    if (cache[n] != 0)
      return cache[n];

    return cache[n] = (recursive(n - 1, cache) + recursive(n - 2, cache)) % MOD;
  }

  private static int calculate(int n, int[] cache) {
    if (n % 2 == 1)
      return recursive(n / 2, cache);
    else
      return (recursive(n / 2, cache) + recursive(n / 2 - 1, cache)) % MOD;
  }

}
