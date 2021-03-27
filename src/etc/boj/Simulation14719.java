package etc.boj;

import java.util.Scanner;

class Simulation14719 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int H = sc.nextInt();
    int W = sc.nextInt();
    boolean[][] board = new boolean[W][H];
    for (int i = 0; i < W; i++) {
      int h = sc.nextInt();
      for (int j = 0; j < h; j++)
        board[i][j] = true;
    }
    for (int j = H - 1; j >= 0; j--) {
      for (int i = 0; i < W; i++)
        System.out.print(board[i][j] ? "1" : "0");
      System.out.println();
    }
  }
}