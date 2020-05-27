package p21numb3rs;

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
      set2();
      for(int r=0; r<retN; r++) {
        town = sc.nextInt();
        System.out.printf("%.8f ", find(town, day));
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

  private static double find(int here, int days) {

    if(days == 0){
      if(here == jail) return 1.0; 
      else return 0.0;
    }
    
    if(cache[here][days] != -1) return cache[here][days];
    
    double ret = 0;
    for(int there=0; there<n; there++) {
      if(board[here][there] == 1) {
        ret += find(there, days-1)/deg[there];
      }
    }
    return cache[here][days] = ret;
  }
}
