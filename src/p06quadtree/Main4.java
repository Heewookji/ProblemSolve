package p06quadtree;

import java.util.Scanner;

public class Main4 {

  static int point;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < testN; i++) {

      String line = sc.nextLine();
      point = 0;
      System.out.println(recursive(line));

    }

  }

  private static String recursive(String line) {

    char head = line.charAt(point++);
    if (head == 'w' || head == 'b')
      return String.valueOf(head);
    
    String upLeft = recursive(line);
    String upRight = recursive(line);
    String downLeft = recursive(line);
    String downRight = recursive(line);

    return "x" + downLeft + downRight + upLeft + upRight;
  }

}
