package p08fanmeeting;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();
    
    for(int t=0; t<testN; t++) {
      String memS = sc.nextLine().replaceAll("M", "1").replaceAll("F", "0");
      String fanS = sc.nextLine().replaceAll("M", "1").replaceAll("F", "0");
      if(fanS.length() < 63) {
        long mems = Long.parseLong(memS, 2);
        long fans = Long.parseLong(fanS, 2);
        int count = 0;
        int index = fanS.length() - memS.length();
        for(int i=0; i<=index; i++) {
          if((fans & (mems<<i)) == 0) count++;
        }
        System.out.println(count);
      } else {
        BigInteger mems = new BigInteger(memS, 2);
        BigInteger fans = new BigInteger(fanS, 2);
        int count = 0;
        int index = fanS.length() - memS.length();
        for(int i=0; i<=index; i++) {
          if((fans.and(mems.shiftLeft(i))).equals(BigInteger.ZERO)) count++;
        }
        System.out.println(count);
      }
    }
  }
}
