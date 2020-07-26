package p05clocksync;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

  static int[][] switches = {
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
  static int[] clocks = new int[16];
  static int MOD = 9999;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    for(int t=0; t<testN; t++) {
      for(int i=0; i<16; i++) {
        clocks[i] = sc.nextInt();
      }
      int ret = find(new ArrayList<Integer>(), 0);
      System.out.println(ret == MOD? -1 : ret);
    }
  }

  private static int find(ArrayList<Integer> clicked, int clickN) {

    if(isEnd()) return clickN;
    if(clicked.size() == 10) return MOD;

    int start = clicked.size() != 0? clicked.get(clicked.size()-1)+1 : 0;
    int ret = MOD;
    
    for(int i=start; i<10; i++) {
      clicked.add(i);
      for(int x=1; x<5; x++) {
       click(i);
       if(x != 4) ret = Math.min(ret, find(clicked, x+clickN));
      }
      clicked.remove(clicked.size()-1);
    }
    return ret;
  }

  private static boolean isEnd() {
    for(int i=0; i<clocks.length; i++) {
      if(clocks[i] != 12) return false;
    }
    return true;
  }
  
  private static void click(int i) {
    for(int j=0; j<switches[i].length; j++) {
      if((clocks[switches[i][j]] += 3) == 15) clocks[switches[i][j]] = 3;
    }
  }

}
