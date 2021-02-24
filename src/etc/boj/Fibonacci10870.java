package etc.boj;

import java.util.*;

public class Fibonacci10870 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    tailRecursive(n, 1, 0);
  }

  private static void tailRecursive(int n, int pre1, int pre2) {
    if (n < 2)
      System.out.println(n * pre1);
    else
      tailRecursive(n - 1, pre1 + pre2, pre1);
  }
}
