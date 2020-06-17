package p06quadtree;

import java.util.Scanner;

public class Main3 {

  static int point = -1;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < testN; i++) {
      String line = sc.nextLine();
      System.out.println(recursive(line, 0));
    }
  }

  private static String recursive(String line, int index) {

    char head = line.charAt(index);
    if (head == 'b' || head == 'w')
      return String.valueOf(head);
    int nextIndex = point == -1 ? index : point;

    String upLeft = recursive(line, nextIndex + 1);
    String upRight = recursive(line, nextIndex + 2);
    String downLeft = recursive(line, nextIndex + 3);
    String downRight = recursive(line, nextIndex + 4);
    
    return "x" + downLeft + downRight + upLeft + upRight;
  }
}
