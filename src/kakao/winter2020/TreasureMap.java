package kakao.winter2020;

import java.util.Scanner;

public class TreasureMap {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
      int n = sc.nextInt();
      int[] arr1 = new int[n];
      int[] arr2 = new int[n];
      
      for(int i=0; i<n; i++) {
        arr1[i] = sc.nextInt();
      }
      for(int i=0; i<n; i++) {
        arr2[i] = sc.nextInt();
      }
      for(int i=0; i<n; i++) {
        String ret = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString((arr1[i] | arr2[i]))));
        ret = ret.replaceAll("1", "#").replaceAll("0", " ");
        System.out.println(ret);
      }
    }
  }
}
