package ㅡ20poly;

import java.util.Scanner;

public class Main {

  static int[][] board;
  static int n;
  static int[][] pos = {{0,1},{1,0},{0,-1},{-1,0}};

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      n = sc.nextInt();
      board = new int[n][n];

      System.out.println( find(n, 0, 0));
    }
  }

  private static int find(int n, int x, int y) {

    if(!isMono()) return 0;
    if(n == 0) return 1;

    int sum = 0;
    for(int i=0; i<4; i++) {
      int nextX = x + pos[i][0];
      int nextY = y + pos[i][1];
      if(!isFilled(nextX,nextY, 1)) {
        sum += find(n-1, nextX, nextY);
      }
      isFilled(nextX, nextY, -1);
    }
    return sum;
  }

  private static boolean isMono() {
    for(int y=0; y<n; y++) {
      boolean flag1 = false;
      boolean flag2 = false;
      for(int x=0; x<n; x++) {
        if(board[y][x] == 1) flag1 = true;
        if(flag1 && board[y][x] == 0) flag2 = true;
        if(flag2 && board[y][x] == 1) return false;
      }
    }
    return true;
  }

  private static boolean isFilled(int x, int y, int flag) {
    if(x<0 || x>=n || y<0 || y>=n) return false;
    if((board[y][x] += flag) > 1 ) return false;
    return true;
  }

}
