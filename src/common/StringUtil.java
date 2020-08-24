package common;

import java.util.Arrays;
import java.util.Scanner;

// 문자열을 다루는 법
public class StringUtil {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String method = scanner.nextLine();
    String ret = "";

    switch (method) {
      case "문자열정렬":
        System.out.print("정렬할문자열 = ");
        ret = sortString(scanner.next());
        break;
      case "문자열뒤집기":
        System.out.print("뒤집을문자열 = ");
        ret = reverseString(scanner.next());
        break;
      default:
        System.out.println("작업을 지정해주세요");
    }
    System.out.println("결과 = " + ret);
    scanner.close();
  }

  private static String sortString(String s) {
    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    return new String(arr);
  }

  private static String reverseString(String s) {
    return new StringBuffer(s).reverse().toString();
  }

}