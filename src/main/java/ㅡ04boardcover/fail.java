package ㅡ04boardcover;

import java.util.Scanner;

public class fail {

  static int xN;
  static int yN;
  static boolean[][] board;
  static int[][] dx = new int[8][2];
  static int[][] dy = new int[8][2];

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    init();

    int caseN = sc.nextInt();

    for(int c=0; c<caseN; c++) {

      yN = sc.nextInt();
      xN = sc.nextInt();
      sc.nextLine();

      board = new boolean[yN][xN];

      for(int y=0; y<yN; y++ ){
        char[] chars = sc.nextLine().toCharArray();
        for( int i=0; i<chars.length; i++) {
          board[y][i] = (chars[i] == '#'? true:false);
        }
      }

      int sum = 0;

      sum = find();

      System.out.println(sum);
    }
    sc.close();
  }

  private static int find() {

    int startX = -1;
    int startY = -1;
    label: for(int y=0; y<yN; y++) {
      for(int x=0; x<xN; x++) {
        if(!board[y][x]) {
          startX = x; startY = y; break label;
        }
      }
    }
    if(startX == -1 && startY == -1) return 1;

    int sum = 0;

    for(int i=0; i<8; i++){
      sum += fill(startX,startY,i);
    }

    return sum;
  }



  private static int fill(int startX, int startY, int i) {

    int oneNextX = startX + dx[i][0];
    int oneNextY = startY + dy[i][0];

    int twoNextX = startX + dx[i][1];
    int twoNextY = startY + dy[i][1];

    int sum = 0;
    if( oneNextX < 0 || oneNextY < 0 || twoNextX < 0 || twoNextY < 0 || 
        oneNextX >= xN || oneNextY >= yN || twoNextX >= xN || twoNextY >= yN) return 0;
    if(board[oneNextY][oneNextX] || board[twoNextY][twoNextX] ) return 0;
    else {
      board[oneNextY][oneNextX] = true;
      board[twoNextY][twoNextX] = true;
      sum += find();
      board[oneNextY][oneNextX] = false;
      board[twoNextY][twoNextX] = false;
    }

    return sum;
  }

  private static void init() {

    dx[0][0] = 0; dx[0][1] = 1;
    dy[0][0] = -1; dy[0][1] = -1;

    dx[1][0] = 0; dx[1][1] = -1;
    dy[1][0] = -1; dy[1][1] = -1;

    dx[2][0] = -1; dx[2][1] = -1;
    dy[2][0] = 0; dy[2][1] = -1;

    dx[3][0] = -1; dx[3][1] = -1;
    dy[3][0] = 0; dy[3][1] = 1;

    dx[4][0] = 0; dx[4][1] = -1;
    dy[4][0] = 1; dy[4][1] = 1;

    dx[5][0] = 0; dx[5][1] = 1;
    dy[5][0] = 1; dy[5][1] = 1;

    dx[6][0] = 1; dx[6][1] = 1;
    dy[6][0] = 0; dy[6][1] = 1;

    dx[7][0] = 1; dx[7][1] = 1;
    dy[7][0] = 0; dy[7][1] = -1;

  }


}