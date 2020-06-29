package p20poly;

import java.util.Scanner;

public class Main2 {

  static final int MOD = 10000000;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      System.out.println(find(n));
    }

  }

  private static int find(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++)
      sum = (sum + recursive(n, i, new int[n + 1][n + 1])) % MOD;
    return sum;
  }

  private static int recursive(int n, int first, int[][] cache) {
    if (n == first)
      return 1;
    if (cache[n][first] != 0)
      return cache[n][first];
    int sum = 0;
    for (int next = 1; next <= n - first; next++)
      sum = (sum + (first + next - 1) * recursive(n - first, next, cache)) % MOD;
    return cache[n][first] = sum;
  }

}
