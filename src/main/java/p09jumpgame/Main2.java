package p09jumpgame;

import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      int[][] board = new int[n][n];
      int[][] cache = new int[n][n];
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
          board[y][x] = sc.nextInt();
        }
      }
      System.out.println(recursive(board, 0, 0, cache) == 1 ? "YES" : "NO");
    }
  }

  private static int recursive(int[][] board, int x, int y, int[][] cache) {

    if (x >= board.length || y >= board.length)
      return -1;
    if (x == board.length - 1 && y == board.length - 1)
      return 1;
    if (cache[y][x] != 0)
      return cache[y][x];
    if (recursive(board, x + board[y][x], y, cache) == 1 || recursive(board, x, y + board[y][x], cache) == 1)
      return 1;
    return cache[y][x] = -1;
  }
}
