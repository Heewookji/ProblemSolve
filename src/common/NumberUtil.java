package common;

import java.util.Scanner;

// 숫자를 다루는 법
public class NumberUtil {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String method = scanner.nextLine();
    int ret = 0;

    switch (method) {
      case "숫자뒤집기":
        System.out.print("뒤집을숫자 = ");
        ret = reverseNumber(scanner.nextInt());
        break;
      default:
        System.out.println("작업을 지정해주세요");
    }
    System.out.println("결과 = " + ret);
    scanner.close();
  }

  private static int reverseNumber(int number) {
    int result = 0;
    while (number > 0) {
      result = result * 10 + number % 10;
      number /= 10;
    }
    return result;
  }

}