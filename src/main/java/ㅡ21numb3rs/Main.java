package ㅡ21numb3rs;

import java.util.Scanner;

public class Main {

  private static int n;
  private static int[][] board;
  private static int jail;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    int ret = 0;
    for(int i=0; i<testN; i++) {
      n = sc.nextInt();
      int d = sc.nextInt();
      jail = sc.nextInt();
      board = new int[n][n];
      for(int y=0; y<n; y++) {
        for(int x=0; x<n; x++) board[y][x] = sc.nextInt();
      }
      int retN = sc.nextInt();
      for(int r=0; r<retN; r++) {
        System.out.printf("%.8f ", find(sc.nextInt(), d, 1));
      }
    }
  }

  private static double find(int town, int day, int tot) {

    if(day == 0){
      if(town == jail) return 1/tot;
      else return 0;
    }

    int sum = 0;
    double ret = 0;
    
    for(int i=0; i<n; i++) {
      if(board[town][i] == 1) {
        sum += 1;
      }
    }
    for(int i=0; i<n; i++) {
      if(board[town][i] == 1) {
        ret += find(i, day-1, sum);
      }
    }
    ret *= 1/tot;
    
    return ret;
  }

}
