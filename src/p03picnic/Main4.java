package p03picnic;

import java.util.Scanner;

public class Main4 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      boolean[] cache = new boolean[n];
      int coupleN = sc.nextInt();
      boolean[][] couple = new boolean[n][n];
      for (int c = 0; c < coupleN; c++)
        couple[sc.nextInt()][sc.nextInt()] = true;
      System.out.println(solve(n, couple, cache));
    }
  }

  private static int solve(final int n, final boolean[][] couple, boolean[] cache) {

    int solo = -1;

    for (int i = 0; i < n; i++) {
      if (!cache[i]) {
        solo = i;
        break;
      }
    }
    if (solo == -1)
      return 1;

    int ret = 0;
    for (int solo2 = solo + 1; solo2 < n; solo2++) {
      if ((couple[solo][solo2] || couple[solo2][solo]) && !cache[solo2]) {
        cache[solo] = cache[solo2] = true;
        ret += solve(n, couple, cache);
        cache[solo] = cache[solo2] = false;
      }
    }
    return ret;
  }
}
