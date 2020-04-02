package boardcover;

import java.util.Scanner;

public class Main {

  static int xN;
  static int yN;
  static int[][] board;
  static int[][][] types = {
      {{0,0},{1,0},{0,1}},
      {{0,0},{0,1},{1,1}},
      {{0,0},{1,0},{1,1}},
      {{0,0},{1,0},{1,-1}}
  };

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int caseN = sc.nextInt();

    for(int c=0; c<caseN; c++) {

      yN = sc.nextInt();
      xN = sc.nextInt();
      sc.nextLine();

      board = new int[yN][xN];

      for(int y=0; y<yN; y++ ){
        char[] chars = sc.nextLine().toCharArray();
        for( int i=0; i<chars.length; i++) {
          board[y][i] = (chars[i] == '#'? 1:0);
        }
      }

      int sum = find();
      System.out.println(sum);
    }
  }

  private static boolean set(int x, int y, int type, int isSet ) {
    boolean ok = true;
    for(int i=0; i<3; i++) {
      int newY = y+types[type][i][0];
      int newX = x+types[type][i][1];
      if(newX < 0 || newX >= xN || newY < 0 || newY >= yN) {
        ok = false;
      } else if((board[newY][newX] += isSet) > 1) {
        ok = false;
      }
    }
    return ok;
  }


  private static int find() {

    int flagX = -1, flagY = -1;
    label: for(int y=0; y<yN; y++) {
      for(int x=0; x<xN; x++) {
        if(board[y][x] == 0) {
          flagX = x; flagY = y; break label;
        }
      }
    }
    if(flagX == -1 && flagY == -1) return 1;

    int sum = 0;
    for(int i=0; i<4; i++) {
      if(set(flagX,flagY, i, 1))
        sum += find();
      set(flagX,flagY, i, -1);
    }
    return sum;
  }


}
