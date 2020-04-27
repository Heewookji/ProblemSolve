package ㅡ16tiling;

import java.io.IOException;
import java.util.Scanner;

public class Main2 {

  static int n;
  static int[] cache;
  static int MOD = 1000000007;

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      n = sc.nextInt();
      cache = new int[n+1];
      
      System.out.println(find(n));

    }
    sc.close();
  }
  private static int find(int width) {
    
    if(width <= 1) return 1;
    if(cache[width] != 0) return cache[width];
    return cache[width] = (find(width-2) + find(width-1)) % MOD; 
    
  }
}
