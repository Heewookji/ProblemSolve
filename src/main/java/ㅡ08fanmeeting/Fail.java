package ㅡ08fanmeeting;

import java.util.Scanner;

public class Fail {

  static String mems;
  static String fans;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t<testN; t++) {
      mems = sc.nextLine();
      fans = sc.nextLine();

      int ret = solve();
      System.out.println(ret);
    }
    sc.close();
  }

  private static int solve() {

    int sum = 0;

    for(int i=0; i<fans.length(); i++) {

      if( i < mems.length() -1 ) continue;
      else if( i == mems.length() -1 ) {
        if(find(fans.substring(0, mems.length()))) sum += 1;
      } else {
        int gap = i - (mems.length() -1);
        if(find(fans.substring(gap, gap+mems.length()))) sum += 1; 
      }
    }
    return sum;
  }

  private static boolean find(String curFans) {
    
    for(int i=0; i<curFans.length(); i++) {
      if(mems.charAt(i) == curFans.charAt(i) && mems.charAt(i) == 'M') {
        return false;
      }
    }
    return true;
  }

}


