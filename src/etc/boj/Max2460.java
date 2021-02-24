package etc.boj;

import java.util.*;

public class Max2460 {
  public static void main(String[] g) {
    Scanner sc = new Scanner(System.in);
    int a = 0, m = 0, i = 10;
    while (i-- > 0)
      m = Math.max(m, a += -sc.nextInt() + sc.nextInt());
    System.out.print(m);
  }
}
