package p19asymtiling;

import java.util.Scanner;

public class Main {
  
  static int[] cache;
  static int[] cache2;
  static int MOD = 1000000007;
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
      int n = sc.nextInt();
      cache = new int[n+1];
      cache2 = new int[n+1];
      int ret = tiling(n);
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
    if(n <= 2) return 0;
    if(cache2[n] != 0) return cache2[n];
    
    int ret = 0;
    ret = (ret + tiling(n-2)) % MOD;
    ret = (ret + tiling(n-4)) % MOD;
    ret = (ret + find(n-3)) % MOD;
    ret = (ret + find(n-3)) % MOD;
    
    return cache2[n] = ret;
  }

}


