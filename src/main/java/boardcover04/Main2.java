package boardcover04;

import java.util.Scanner;

public class Main2 {

  static int[][] board;
  static int yN;
  static int xN;
  static int[][][] pos = {
      {{0,0},{0,1},{-1,1}},
      {{0,0},{0,1},{1,1}},
      {{0,0},{1,0},{0,1}},
      {{0,0},{1,0},{1,1}}
  };

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      yN = sc.nextInt();
      xN = sc.nextInt();
      sc.nextLine();

      board = new int[yN][xN];

      for(int y=0; y<yN; y++) {
        String line = sc.nextLine();
        for(int i=0; i<line.length(); i++) {
          board[y][i] = (line.charAt(i) == '#'? 1 : 0);
        }
      }
      int result = find();
      System.out.println(result);
    }
    sc.close();
  }

  private static int find() {

    int x = -1;
    int y = -1;

    label: for(int sy=0; sy<yN; sy++) {
      for(int sx=0; sx<xN; sx++) {
        if(board[sy][sx] == 0) {
          y = sy;
          x = sx;
          break label;
        }
      }
    }
    if(x == -1 && y == -1) return 1;

    int sum = 0;
    for(int i=0; i<4; i++) {
      if(next(i,x,y,1)) {
        sum += find();
      }
      next(i,x,y,-1);
    }
    return sum;
  }

  private static boolean next(int i, int x, int y, int opt) {

    boolean flag = true;
    for(int count=0; count<3; count++) {
      int nextX = x + pos[i][count][0];
      int nextY = y + pos[i][count][1];
      if(nextX < 0 || nextX >= xN || nextY < 0 || nextY >= yN) {
        flag = false; continue;
      }
      if((board[nextY][nextX] += opt) > 1) flag = false;
    }
    return flag;
  }
}

/**
3
3 7
#.....#
#.....#
##...##
3 7
#.....#
#.....#
##..###
8 10
##########
#........#
#........#
#........#
#........#
#........#
#........#
##########
 **/
