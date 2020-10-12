package p04boardcover;

import java.util.Scanner;

public class Main4 {

  static final int[][] dx = { { 0, 0, -1 }, { 0, 0, 1 }, { 0, 1, 1 }, { 0, 0, 1 } },
      dy = { { 0, 1, 1 }, { 0, 1, 1 }, { 0, 0, 1 }, { 1, 0, 0 } };

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int h = sc.nextInt();
      int w = sc.nextInt();
      int[][] board = new int[h][w];
      sc.nextLine();
      for (int y = 0; y < h; y++) {
        char[] line = sc.nextLine().toCharArray();
        for (int x = 0; x < w; x++)
          board[y][x] = line[x] == '#' ? 1 : 0;
      }
      System.out.println(recursive(board));
    }
  }

  private static int recursive(int[][] board) {

    int[] pos = findUnfilled(board);
    if (pos[0] == -1 && pos[1] == -1)
      return 1;
    int sum = 0;
    for (int i = 0; i < 4; i++) {
      if (fillUnfill(pos[0], pos[1], i, board, 1))
        sum += recursive(board);
      fillUnfill(pos[0], pos[1], i, board, -1);
    }
    return sum;
  }

  private static int[] findUnfilled(int[][] board) {

    for (int y = 0; y < board.length; y++) {
      for (int x = 0; x < board[0].length; x++) {
        if (board[y][x] == 0)
          return new int[] { x, y };
      }
    }
    return new int[] { -1, -1 };
  }

  private static boolean fillUnfill(int x, int y, int index, int[][] board, int fillFlag) {
    boolean flag = true;
    for (int i = 0; i < 3; i++) {
      int nextX = x + dx[index][i];
      int nextY = y + dy[index][i];
      if (nextX < 0 || nextY < 0 || nextX >= board[0].length || nextY >= board.length
          || (board[nextY][nextX] += fillFlag) > 1)
        flag = false;
    }
    return flag;
  }

}
