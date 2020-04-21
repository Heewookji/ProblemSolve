package trianglepath11;

import java.util.Scanner;

public class Main {
  
  static int[][] triangle;
  static int yN;
  static int[][] cache;

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
      yN = sc.nextInt();
      triangle = new int[yN][yN];
      cache = new int[yN][yN];
      
      for(int y=0; y<yN; y++) {
        for(int x=0; x<y+1; x++) {
          triangle[y][x] = sc.nextInt();
        }
      }
      
      int ret = find(0,0);
      System.out.println(ret);
    }
    sc.close();
  }
  
  private static int find(int x, int y) {
    
    if(y == yN - 1) return triangle[y][x];
    if(cache[y][x] != 0) return cache[y][x];
    
    int sum = triangle[y][x];
    
    sum += Math.max(find(x,y+1), find(x+1,y+1));
    
    cache[y][x] = sum;
    
    return sum;
  }
  
}
