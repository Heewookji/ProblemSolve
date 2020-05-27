package ㅡetc.kakao;


public class Keypad {

  static int[] numbers = {
      1,3,4,5,8,2,1,4,5,9,5
  };
  static int[] test = {
      7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2
  };
  static String hand = "right";

  static int[][] board = {
      {3,1},
      {0,0},
      {0,1},
      {0,2},
      {1,0},
      {1,1},
      {1,2},
      {2,0},
      {2,1},
      {2,2}
  };
  static int[] left = {3,0};
  static int[] right = {3,2};

  public static void main(String[] args) {
    System.out.println(solution(test, hand));
  }

  public static String solution(int[] numbers, String hand) {

    String answer = "";

    for(int i=0; i<numbers.length; i++) {

      switch (numbers[i]) {
        case 1:
        case 4:
        case 7: answer += "L"; left = board[numbers[i]]; break;
        case 3:
        case 6:
        case 9: answer += "R"; right = board[numbers[i]]; break;
        case 2:
        case 5:
        case 8:
        case 0: 
          boolean leftFlag = false;
          int leftGap = Math.abs(board[numbers[i]][0] - left[0]) + Math.abs(board[numbers[i]][1] - left[1]);
          int rightGap = Math.abs(board[numbers[i]][0] - right[0]) + Math.abs(board[numbers[i]][1] - right[1]);
          if(leftGap < rightGap) {
            leftFlag = true;
          } else if(leftGap == rightGap) {
            if(hand.equals("left")){
              leftFlag = true;
            }
          }
          if(leftFlag) {
            answer += "L"; 
            left = board[numbers[i]];
          } else {
            answer += "R"; 
            right = board[numbers[i]];
          }
      }
    }
    return answer;
  }


}
