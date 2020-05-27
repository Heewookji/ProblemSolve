package etc.baekjoon.ㅡ2588;

import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int i = 1;
    int bTemp = b;
    int bCopy = b;
    while(i < 4) {
      bTemp = bCopy%10;
      bCopy = bCopy-bTemp;
      bCopy = bCopy/10;
      System.out.println(a * bTemp);
      i++;
    }
    System.out.println(a*b);
    /**
     * System.out.println(a * b);
    String line = Integer.toString(b);
    System.out.println(a * (line.charAt(2) -'0'));
    System.out.println(a * (line.charAt(1) -'0'));
    System.out.println(a * (line.charAt(0) -'0'));
    System.out.println(a*b);
    **/
  }
}
