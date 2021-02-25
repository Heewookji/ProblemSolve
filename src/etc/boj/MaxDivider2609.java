package etc.boj;

import java.util.Scanner;

public class MaxDivider2609 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt(), n2 = sc.nextInt();
    int gcd = 1;
    for (int i = 2; i <= Math.min(n1, n2); i++)
      if (n1 % i == 0 && n2 % i == 0) gcd = i;
    System.out.println(gcd + "\n" + (n1 * n2 / gcd));
  }
}
