package boardcover;

import java.util.Scanner;

public class Main {

  static int xN;
  static int yN;
  static int[][] dx;
  static int[][] dy;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int caseN = sc.nextInt();

    for(int c=0; c<caseN; c++) {

      yN = sc.nextInt();
      xN = sc.nextInt();
      sc.nextLine();

      boolean[][] board = new boolean[yN][xN];

      for(int y=0; y<yN; y++ ){
        char[] chars = sc.nextLine().toCharArray();
        for( int i=0; i<chars.length; i++) {
          board[y][i] = (chars[i] == '#'? true:false);
        }
      }

      int sum = 0;

      sum = find(board);
    }
  }

  private static int find(boolean[][] board) {

    int flagX = -1;
    int flagY = -1;
    for(int y=0; y<yN; y++) {
      for(int x=0; x<xN; x++) {
        if(!board[y][x]) {
          flagX = x; flagY = y;
        }
      }
    }
    if(flagX == -1) return 1;

    int sum = 0;
    
    for(int i=0; i<8; i++){
      
    }

    return 1;
  }


}
