package p17tripathcnt;

import java.util.Scanner;

public class Main {

  static int[][] triangle;
  static int[][] cache;
  static int[][] countCache;
  static int n;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {
      n = sc.nextInt();
      triangle = new int[n][n];
      cache = new int[n][n];
      countCache = new int[n][n];
      for(int y=0; y<n; y++) {
        for(int x=0; x<y+1; x++) {
          triangle[y][x] = sc.nextInt();
        }
      }
      calculate(0,0);
      System.out.println(find(0,0));
    }
  }

  private static int find(int x, int y) {
    
    if(y == n-1) return 1;
    if(countCache[y][x] != 0) return countCache[y][x];
    int ret = 0;
    int a = cache[y+1][x];
    int b = cache[y+1][x+1];
    if(a >= b) ret += find(x,y+1);
    if(a <= b) ret += find(x+1,y+1);
    return countCache[y][x] = ret;
  }
  
 private static int calculate(int x, int y) {
    
    if(y == n - 1) return cache[y][x] = triangle[y][x];
    if(cache[y][x] != 0) return cache[y][x];
    int sum = triangle[y][x];
    sum += Math.max(calculate(x,y+1), calculate(x+1,y+1));
    return cache[y][x] = sum;
  }

}
