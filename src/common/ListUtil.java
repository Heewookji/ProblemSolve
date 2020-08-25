package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 리스트를 다루는 법
public class ListUtil {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("실행할 작업 = ");
    String method = scanner.nextLine();
    List<Integer> origin = new ArrayList<>();
    for (int i = 0; i < 10; i++)
      origin.add(i);
    List<Integer> ret = null;
    System.out.println("원본 = " + origin.toString());

    switch (method) {
      case "일부분뒤집기":
        ret = reverse(origin);
        break;
      default:
        System.out.println("작업을 지정해주세요");
    }
    System.out.println("결과 = " + ret.toString());
    scanner.close();
  }

  private static List<Integer> reverse(List<Integer> list) {
    Collections.reverse(list.subList(3, 6));
    return list;
  }

}