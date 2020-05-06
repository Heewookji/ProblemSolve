package ㅡ07fence;

import java.util.Scanner;

public class Main2 {

  static int[] fence;
  static int n;
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
      n = sc.nextInt();
      fence = new int[n];
      
      for(int i=0; i<n; i++) {
        fence[i] = sc.nextInt();
      }
      System.out.println(find(0, n-1));
    }
  }
  
  private static int find(int start, int end) {
    return 0;
  }
}
