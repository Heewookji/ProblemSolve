package etc.boj;

import java.util.Scanner;

public class Prime1978 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count = 0;
    for (int i = 0; i < n; i++)
      if (isPrime(sc.nextInt())) count++;
    System.out.println(count);
  }

  private static boolean isPrime(int num) {
    if (num == 1) return false;
    for (int i = 2; i * i <= num; i++)
      if (num % i == 0) return false;
    return true;
  }
}
