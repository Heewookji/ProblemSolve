package ㅡ02boggle;

import java.util.Scanner;

public class Main4 {

  static char[][] board = new char[5][5];
  static String keyword;
  static int[][] path = {
      {-1,0},
      {-1,1},
      {-1,-1},
      {1,0},
      {1,-1},
      {1,1},
      {0,-1},
      {0,1}
  };
  static int[][][] cache;
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t<testN; t++) {

      for(int y=0; y<5; y++) {
        board[y] = sc.nextLine().toCharArray();
      }

      int keywordN = sc.nextInt();
      sc.nextLine();
      
      for(int i=0; i<keywordN; i++) {
        keyword = sc.nextLine();
        cache = new int[5][5][keyword.length()];

        boolean flag = false;
        label: for(int y=0; y<5; y++) {
          for(int x=0; x<5; x++) {
            if(board[y][x] == keyword.charAt(0)) {
              flag = find(x,y,0) == 1? true : false;
            }
            if(flag) break label;
          }
        }
        System.out.println(keyword+" "+(flag?"YES":"NO"));
      }
    }
  }

  private static int find(int x, int y, int index) {
    
    if(x<0||x>4||y<0||y>4) return -1;
    if(board[y][x] != keyword.charAt(index)) return -1;
    if(index == keyword.length()-1) return 1;
    
    if(cache[y][x][index] != 0) return cache[y][x][index];
    
    for(int i=0; i<8; i++) {
      int nextX = x+path[i][0];
      int nextY = y+path[i][1];
      if(find(nextX, nextY, index+1) == 1) return cache[y][x][index] = 1;
    }
    return cache[y][x][index] = -1;
  }
  
}