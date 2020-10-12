package p20poly;

import java.util.Scanner;

public class Main {

  static int[][] cache;
  static int MOD = 10000000;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      int n = sc.nextInt();
      cache = new int[n+1][n+1];
      int sum = 0;
      for(int i=1; i<=n; i++) {
        sum = (sum + find(n, i))%MOD;
      }
      System.out.println(sum);
    }
  }

  private static int find(int n, int first) {

    if(n == first) return 1;
    if(cache[n][first] != 0) return cache[n][first];
    int sum = 0;
    for(int second=1; second<=n-first; second++) {
      sum = (sum + (first+second-1) * find(n-first, second))%MOD;
    }
    return cache[n][first] = sum;
  }


}
