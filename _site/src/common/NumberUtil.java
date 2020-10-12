package common;

import java.util.Scanner;

// 숫자를 다루는 법
public class NumberUtil {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("실행할 작업 = ");
    String method = scanner.nextLine();
    System.out.print("숫자 = ");
    int origin = scanner.nextInt();
    int ret = 0;

    switch (method) {
      case "뒤집기":
        ret = reverse(origin);
        break;
      case "연속숫자개수":
        System.out.print("찾을 숫자 = ");
        ret = findContinuous(origin, scanner.nextInt());
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

  private static int findContinuous(int num, int target) {
    int ret = 0;
    int count = 0;
    int past = 0;

    while (num > 0) {
      int i = num % 10;
      if (i == target && (count == 0 || past == target))
        count++;
      else {
        ret = Math.max(ret, count);
        count = 0;
      }
      num /= 10;
      past = i;
    }

    return Math.max(ret, count);
  }

}