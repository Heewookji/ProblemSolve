package p16tiling;

import java.io.IOException;
import java.util.Scanner;

public class Main {

  static int[][] board;
  static int[][] cache;
  static int[][] dx = {{0,1},{0,0}};
  static int[][] dy = {{0,0},{0,1}};
  static int n;
  static int MOD = 1000000007;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      n = sc.nextInt();

      board = new int[n][2];
      cache = new int[n][2];

      System.out.println(find());

    }
    sc.close();
  }

  private static int find() {

    int newX = -1;
    int newY = -1;
    label: for(int x=0; x<2; x++) {
      for(int y=0; y<n; y++) {
        if(board[y][x] == 0) {
          newX = x;
          newY = y;
          break label;
        }
      }
    }
    if(newX == -1) return 1;
    if(cache[newY][newX] != 0) return cache[newY][newX];

    int sum = 0;

    for(int i=0; i<2; i++) {
      if(isChecked(newX, newY, i, 1)) sum += find();
      isChecked(newX, newY, i, -1);
    }
    return cache[newY][newX] = sum%MOD;
  }

  private static boolean isChecked(int x, int y, int type, int flag) {

    boolean ret = true;
    for(int i=0; i<2; i++) {
      int newX = x + dx[type][i];
      int newY = y + dy[type][i];
      if(newX >= 2 || newY >= n) {
        ret = false;
        continue;
      }
      if((board[newY][newX] += flag) == 2) ret = false;
    }
    return ret;
  }


}
