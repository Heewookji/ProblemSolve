package etc.boj;

import java.util.Scanner;

public class Prime2581 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    int N = sc.nextInt();
    int sum = 0;
    int min = Integer.MAX_VALUE;
    for (int i = M; i <= N; i++) {
      if (isPrime(i)) {
        sum += i;
        min = Math.min(min, i);
      }
    }
    if (sum == 0) System.out.println(-1);
    else {
      System.out.println(sum);
      System.out.println(min);
    }
  }

  private static boolean isPrime(int num) {
    if (num < 2) return false;
    for (int i = 2; i * i <= num; i++)
      if (num % i == 0)
        return false;
    return true;
  }
}
