package ㅡ09jumpgame;

import java.util.Scanner;

public class Main {
  
  static int[][] board;
  static int[][] cache;
  static int boardN;
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      boardN = sc.nextInt();
      board = new int[boardN][boardN];
      cache = new int[boardN][boardN];

      for(int y=0; y<boardN; y++) {
        for(int x=0; x<boardN; x++) {
          board[y][x] = sc.nextInt();
        }
      }
      int flag = find(0,0);
      System.out.println((flag == 1? "YES" : "NO"));
    }
    sc.close();
  }
  
  private static int find(int x, int y) {
    
    if(x<0 || x>= boardN || y<0 || y>=boardN) {
      return -1;
    }
    if(board[y][x] == 0) return 1;
    if(cache[y][x] != 0) return cache[y][x];
    
    int newX = board[y][x] + x;
    int newY = board[y][x] + y;
    
    int flag = 0;
    
    for(int i=0; i<2; i++) {
      if(i==0) flag = find(newX, y);
      else flag = find(x, newY);
      if(flag == 1) return 1;
    }
    return cache[y][x] = -1;
  }

}
