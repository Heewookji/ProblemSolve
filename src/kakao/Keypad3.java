package kakao;

import java.util.Scanner;

class Point {

  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getDistance(Point another) {
    return Math.abs(this.x - another.x) + Math.abs(this.y - another.y);
  }
}

public class Keypad3 {

  final static Point[] keypad = { new Point(3, 1), new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(1, 0),
      new Point(1, 1), new Point(1, 2), new Point(2, 0), new Point(2, 1), new Point(2, 2), new Point(3, 0),
      new Point(3, 2) };
  final static int STAR = 10;
  final static int HASH = 11;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(new Keypad3().solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
  }

  public String solution(int[] numbers, String hand) {
    String ret = "";
    Point leftPos = keypad[STAR];
    Point rightPos = keypad[HASH];
    for (int i : numbers) {
      switch (i) {
        case 1:
        case 4:
        case 7:
          ret += "L";
          leftPos = keypad[i];
          break;
        case 3:
        case 6:
        case 9:
          ret += "R";
          rightPos = keypad[i];
          break;
        default:
          if (leftPos.getDistance(keypad[i]) < rightPos.getDistance(keypad[i])) {
            ret += "L";
            leftPos = keypad[i];
          } else if (rightPos.getDistance(keypad[i]) < leftPos.getDistance(keypad[i])) {
            ret += "R";
            rightPos = keypad[i];
          } else {
            if (hand.equals("left")) {
              ret += "L";
              leftPos = keypad[i];
            } else {
              ret += "R";
              rightPos = keypad[i];
            }
          }
      }
    }
    return ret;
  }
}