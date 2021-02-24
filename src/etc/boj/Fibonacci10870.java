package etc.boj;

import java.util.*;

public class Fibonacci10870 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if(n < 1) {
      System.out.println(n);
      return;
    }
    int[] list = new int[n + 1];
    list[0] = 0;
    list[1] = 1;
    for (int i = 2; i < list.length; i++)
      list[i] = list[i - 1] + list[i - 2];
    System.out.println(list[n]);
  }
}
