package ㅡ19asymtiling;

import java.util.Scanner;

public class Main2 {
  
  static int[] cache;
  static int MOD = 1000000007;
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
      int n = sc.nextInt();
      cache = new int[n+1];
      int ret = find(n);
      int min = tiling(n);
      ret = (ret - min + MOD) % MOD;
      System.out.println(ret);
    }
  }
  
  private static int find(int n) {
    if(n <= 1) return 1;
    if(cache[n] != 0) return cache[n];
    int sum = 0;
    sum = find(n-1) + find(n-2);
    return cache[n] = sum % MOD;
  }
  
  private static int tiling(int n) {
    if(n % 2 == 0) {
      return (find(n/2) + find(n/2-1)) % MOD;
    } else {
      return find((n-1)/2);
    }
  }

}


