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



// class Solution {
//     int tempL = 10;
//     int tempR = 12;
//     String myhand;
//     public String solution(int[] numbers, String hand) {
//         myhand = ((hand.equals("right"))? "R": "L");
//         String answer = "";
//         for(int i=0 ; i< numbers.length ; i++) {
//             switch(numbers[i]) {
//                 case 1: case 4: case 7:
//                     answer += "L";
//                     tempL = numbers[i];
//                     break;
//                 case 3: case 6: case 9:
//                     answer += "R";
//                     tempR = numbers[i];
//                     break;
//                 default:
//                     String tempHand = checkHand(numbers[i]);
//                     if(tempHand.equals("R"))
//                         tempR = numbers[i] + ((numbers[i] == 0)? 11:0);
//                     else tempL = numbers[i] + ((numbers[i] == 0)? 11:0);
//                     answer += tempHand;
//                     break;
//             }
//         }
//         return answer;
//     }

//     private String checkHand(int tempNum) {
//         int leftDistance = 0;
//         int rightDistance = 0;
//         if(tempNum == 0) tempNum = 11;

//         leftDistance = Math.abs((tempNum-1)/3 - (tempL-1)/3) + Math.abs((tempNum-1)%3 - (tempL-1)%3);
//         rightDistance = Math.abs((tempNum-1)/3 - (tempR-1)/3) + Math.abs((tempNum-1)%3 - (tempR-1)%3);
//         System.out.println(tempNum + ": " + leftDistance + ", " + rightDistance);
//         return ((leftDistance == rightDistance)? myhand: (leftDistance > rightDistance)? "R": "L");

//     }
// }