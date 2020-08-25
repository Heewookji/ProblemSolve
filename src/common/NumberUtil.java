package common;

import java.util.Scanner;

// 숫자를 다루는 법
public class NumberUtil {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("실행할 작업 = ");
    String method = scanner.nextLine();
    int origin = 123;
    int ret = 0;
    System.out.println("숫자 = " + origin);

    switch (method) {
      case "뒤집기":
        ret = reverse(origin);
        break;
      default:
        System.out.println("작업을 지정해주세요");
    }
    System.out.println("결과 = " + ret);
    scanner.close();
  }

  private static int reverse(int number) {
    int result = 0;
    while (number > 0) {
      result = result * 10 + number % 10;
      number /= 10;
    }
    return result;
  }

}