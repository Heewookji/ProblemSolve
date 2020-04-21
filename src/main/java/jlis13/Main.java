package jlis13;

import java.util.Scanner;

public class Main {
  
  static int[] aL;
  static int[] bL;
  static int aN;
  static int bN;
  static int[][] cache;
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
      aN = sc.nextInt();
      bN = sc.nextInt();
      aL = new int[aN];
      bL = new int[bN];
      cache = new int[aN][bN];
      
      for(int i=0; i<aN; i++) {
        aL[i] = sc.nextInt();
      }
      for(int i=0; i<bN; i++) {
        bL[i] = sc.nextInt();
      }
      int ret = find(-1,-1);
      System.out.println(ret);
    }
  }
  
  private static int find(int indexA, int indexB) {
    
    int ret = 2;
    int a = (indexA == -1? 0 : aL[indexA]);
    int b = (indexB == -1? 0 : bL[indexB]);
    int max = Math.max(a, b);
    for(int nextA=indexA+1; nextA<aN; nextA++) {
      if(max < aL[nextA]) ret = Math.max(ret, find(nextA, indexB) + 1);
    }
    for(int nextB=indexB+1; nextB<bN; nextB++) {
      if(max < bL[nextB]) ret = Math.max(ret, find(indexA, nextB) + 1);
    }
    return ret;
  }
  
  
}
