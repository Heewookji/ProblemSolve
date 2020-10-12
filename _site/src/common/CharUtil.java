package common;

import java.util.Scanner;

// char를 다루는 법
public class CharUtil {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("실행할 작업 = ");
    String method = scanner.nextLine();
    System.out.print("원본 = ");
    char origin = scanner.next().charAt(0);
    Object ret = null;

    switch (method) {
      case "영문을숫자로":
        ret = alphabetToNum(origin);
        break;
      case "숫자를숫자로":
        ret = numToNum(origin);
        break;
      default:
        System.out.println("작업을 지정해주세요");
    }
    System.out.println("결과 = " + ret);
    scanner.close();
  }

  private static int alphabetToNum(char origin) {
    if (!Character.isUpperCase(origin))
      return origin - 'a';
    else
      return origin - 'A';
  }

  private static int numToNum(char origin) {
    return origin - '0';
  }

}