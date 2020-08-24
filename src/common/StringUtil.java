package common;

import java.util.Arrays;
import java.util.Scanner;

// 문자열을 다루는 법
public class StringUtil {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String method = scanner.nextLine();
    String origin = "eafcbd";
    String ret = "";
    System.out.println("문자열 = " + origin);

    switch (method) {
      case "정렬":
        ret = sort(origin);
        break;
      case "뒤집기":
        ret = reverse(origin);
        break;
      default:
        System.out.println("작업을 지정해주세요");
    }
    System.out.println("결과 = " + ret);
    scanner.close();
  }

  private static String sort(String s) {
    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    return new String(arr);
  }

  private static String reverse(String s) {
    return new StringBuffer(s).reverse().toString();
  }

}