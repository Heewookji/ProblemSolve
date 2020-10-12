package p02boggle;

import java.util.Scanner;

public class Main3 {

  static char[][] board = null;
  static int[][] pos = {
      {0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,-1},{1,1}
  };
  static int[][][] dp;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t<testN; t++) {
      board = new char[5][5];
      for(int y=0; y<5; y++) {
        board[y] = sc.nextLine().toCharArray();
      }
      int wordN = sc.nextInt();
      sc.nextLine();
      
      for(int w=0; w<wordN; w++) {
        String keyword = sc.nextLine();
        boolean flag = false;
        dp = new int[5][5][10];
        
        label: for(int y=0; y<5; y++) {
          for(int x=0; x<5; x++) {
            if(board[y][x] == keyword.charAt(0)) {
              flag = find(keyword, x, y, 0);
              if(flag) break label;
            }
          }
        }
        System.out.println(keyword + " " + (flag? "YES":"NO"));
      }
    }
    sc.close();
  }

  static boolean find(String keyword, int x, int y, int index) {

    if(x<0 || x>=5 || y<0 || y>=5) return false;
    if(index >= keyword.length()) return true;
    if(board[y][x] != keyword.charAt(index)) return false;
    if(dp[y][x][index] == 1) return true;
    else if(dp[y][x][index] == -1) return false;

    boolean flag = false;

    for(int p=0; p<8; p++) {
      int nextX = x + pos[p][0];
      int nextY = y + pos[p][1];
      flag = find(keyword, nextX, nextY, index+1);
      if(flag) {
        dp[y][x][index] = 1;
        return true;
      }
    }
    dp[y][x][index] = -1;
    return false;
  }
}
