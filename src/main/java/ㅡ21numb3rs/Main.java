package ㅡ21numb3rs;

import java.util.Scanner;

public class Main {

  private static int n;
  private static int[][] board;
  private static int[] deg;
  private static int[] path;
  private static int jail;
  private static int town;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();
    int ret = 0;
    for(int i=0; i<testN; i++) {
      n = sc.nextInt();
      int day = sc.nextInt();
      jail = sc.nextInt();
      board = new int[n][n];
      deg = new int[n];
      for(int y=0; y<n; y++) {
        for(int x=0; x<n; x++) board[y][x] = sc.nextInt();
      }
      int retN = sc.nextInt();
      path = new int[day];
      set();
      for(int r=0; r<retN; r++) {
        town = sc.nextInt();
        System.out.printf("%.8f ", find(path, day));
      }
    }
  }

  private static void set() {
    
    for(int y=0; y<n; y++) {
      for(int x=0; x<n; x++) {
        if(board[y][x] == 1) {
          deg[y]++;
        }
      }
    }
  }

  private static double find(int[] path, int day) {

    double ret = 1;
    
    if(day == 0){
      if(path[path.length-1] == town) {
        for(int p:path) {
          ret /= deg[p];
        }
        return ret;
      } else return 0.0;
    }
    
    ret = 0;
    for(int i=0; i<n; i++) {
      if(board[jail][i] == 1) {
        ret += find(path, day-1);
      }
    }
    return ret;
  }
}
