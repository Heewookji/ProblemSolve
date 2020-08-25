package kakao;

public class Keypad2 {

  final static int[][] distance = { { 0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1 }, {}, { 3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4 },
      {}, {}, { 2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3 }, {}, {}, { 1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2 }, {} };

  public static void main(String[] args) {
    System.out.println(solve(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
  }

  public static String solve(int[] numbers, String hand) {

    int left = 10;
    int right = 11;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < numbers.length; i++) {

      int nextNum = numbers[i];
      String next = "";

      if (nextNum == 1 || nextNum == 4 || nextNum == 7) {
        left = nextNum;
        next = "L";
      } else if (nextNum == 3 || nextNum == 6 || nextNum == 9) {
        right = nextNum;
        next = "R";
      } else {
        if (distance[nextNum][left] < distance[nextNum][right]) {
          left = nextNum;
          next = "L";
        } else if (distance[nextNum][left] > distance[nextNum][right]) {
          right = nextNum;
          next = "R";
        } else {
          if (hand.equals("left")) {
            left = nextNum;
            next = "L";
          } else {
            right = nextNum;
            next = "R";
          }
        }
      }
      sb.append(next);
    }
    return sb.toString();
  }

}
