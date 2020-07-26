package p04boardcover;

import java.util.Scanner;

public class Main3 {

  static int h;
  static int w;
  static int[][] board;
  static int[][] dx = {
      {0,0,-1},
      {0,0,1},
      {0,1,1},
      {0,1,0}
  };
  static int[][] dy = {
      {0,1,1},
      {0,1,1},
      {0,0,1},
      {0,0,1}
  };

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      h = sc.nextInt();
      w = sc.nextInt();
      sc.nextLine();
      board = new int[h][w];

      for(int y=0; y<h; y++) {
        char[] array = sc.nextLine().toCharArray();
        for(int x=0; x<w; x++) {
          board[y][x] = (array[x] == '#'? 1 : 0);
        }
      }
      System.out.println(find());
    }
  }

  private static int find() {

    int x = -1;
    int y = -1;
    label: for(int by=0; by<h; by++) {
      for(int bx=0; bx<w; bx++) {
        if(board[by][bx] == 0) {
          x = bx;
          y = by;
          break label;
        }
      }
    }
    if(x == -1) return 1;

    int sum = 0;
    for(int i=0; i<4; i++) {
      if(check(i, x, y, 1)) sum += find();
      check(i, x, y, -1);
    }
    return sum;
  }

  private static boolean check(int type, int x, int y, int flag) {

    boolean ret = true;
    for(int i=0; i<3; i++) {
      int nextX = x+dx[type][i];
      int nextY = y+dy[type][i];
      if(nextX<0||nextX>=w||nextY<0||nextY>=h) {
        ret = false;
        continue;
      }
      if((board[nextY][nextX] += flag) > 1) ret = false;
    }
    return ret;
  }


}
