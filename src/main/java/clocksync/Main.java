package clocksync;

import java.util.Scanner;

public class Main {

  static int[] clocks;
  static int[][] move = {
      {0,1,2},
      {3,7,9,11},
      {4,10,14,15},
      {0,4,5,6,7},
      {6,7,8,10,12},
      {0,2,14,15},
      {3,14,15},
      {4,5,7,14,15},
      {1,2,3,4,5},
      {3,4,5,9,13}
  };
  static int INF = 9999;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {
      clocks = new int[16];
      for(int i=0; i<16; i++) {
        clocks[i] = sc.nextInt();
      }

      int result = find(0);

      System.out.println(result >= INF? -1 : result);
    }
    sc.close();
  }

  private static int find(int switchN) {

    if(isFinished()) return 0;
    if(switchN == 10) return INF;

    int ret = INF;
    for(int i=0; i<4; i++) {
      ret = Math.min(ret, i + find(switchN + 1));
      click(move[switchN]);
    }
    return ret;
  }

  private static boolean isFinished() {
    for(int i=0; i<clocks.length; i++) {
      if(clocks[i] != 12) return false;
    }
    return true;
  }

  private static void click(int[] clockList) {
    for(int i=0; i<clockList.length; i++) {
      clocks[clockList[i]] = clocks[clockList[i]] + 3;
      if(clocks[clockList[i]] == 15) clocks[clockList[i]] = 3;
    }
  }

}
