package p12lis;

import java.util.Scanner;

public class Main {

  static int[] numbs;
  static int nN;
  static int[] cache;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      nN = sc.nextInt();
      numbs = new int[nN];
      cache = new int[nN];

      for(int n=0; n<nN; n++) {
        numbs[n] = sc.nextInt();
      }
      int ret = 0;
      for(int i=0; i<nN; i++) {
        int temp = find(i);
        if(ret < temp) ret = temp;
      }
      System.out.println(ret);
    }
    sc.close();
  }

  private static int find(int start) {

    if(cache[start] != 0) return cache[start];

    int ret = 1;
    for(int next=start+1; next<nN; next++) {
      if(numbs[start] < numbs[next]) {
        ret = Math.max(ret, find(next) + 1);
      }
    }
    return cache[start] = ret;
  }

}
