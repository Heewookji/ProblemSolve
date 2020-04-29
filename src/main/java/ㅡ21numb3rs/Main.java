package ㅡ21numb3rs;

import java.util.Scanner;

public class Main {

  private static int n;
  private static int[][] board;
  private static int[] deg;
  private static int day;
  private static int jail;
  private static int town;
  private static double[][] cache; 

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();
    for(int i=0; i<testN; i++) {
      n = sc.nextInt();
      day = sc.nextInt();
      jail = sc.nextInt();
      board = new int[n][n];
      deg = new int[n];
      cache = new double[n][day+1];
      for(int y=0; y<n; y++) {
        for(int x=0; x<n; x++) board[y][x] = sc.nextInt();
      }
      int retN = sc.nextInt();
      set();
      for(int r=0; r<retN; r++) {
        town = sc.nextInt();
        set2();
        System.out.printf("%.8f ", find(jail, day));
      }
    }
  }

  private static void set2() {
    for(int y=0; y<cache.length; y++) {
      for(int x=0; x<cache[y].length; x++) {
        cache[y][x] = -1;
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

  private static double find(int currentT, int leftD) {

    if(leftD == 0){
      if(currentT == town) return 1; 
      else return 0.0;
    }
    
    if(cache[currentT][leftD] != -1) return cache[currentT][leftD];
    
    double ret = 0;
    for(int i=0; i<n; i++) {
      if(board[currentT][i] == 1) {
        ret += find(i, leftD-1)/deg[currentT];
      }
    }
    return cache[currentT][leftD] = ret;
  }
}
