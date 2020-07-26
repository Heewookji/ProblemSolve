package p07fence;

import java.util.Scanner;

public class Main3 {

  static int MAX = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      int[] board = new int[n];
      for (int j = 0; j < n; j++)
        board[j] = sc.nextInt();
      System.out.println(recursive(board, 0, board.length - 1));
    }
  }

  private static int recursive(final int[] board, int start, int end) {

    if (start == end)
      return board[start];
    int half = (start + end) / 2;
    int ret = Math.max(recursive(board, start, half), recursive(board, half + 1, end));

    int left = half, right = half + 1;
    int least = Math.min(board[left], board[right]);
    ret = Math.max(ret, least * 2);

    while (left > start || right < end) {
      if (right < end && (left == start || board[left - 1] < board[right + 1])) {
        least = Math.min(least, board[right + 1]);
        right++;
      } else {
        least = Math.min(least, board[left - 1]);
        left--;
      }
      ret = Math.max(ret, (right - left + 1) * least);
    }
    return ret;
  }
}
