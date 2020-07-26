package p07fence;

import java.util.Scanner;

public class Main {

  static int[] woods;
  static int woodN;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      woodN = sc.nextInt();
      woods = new int[woodN];

      for(int w=0; w<woodN; w++){
        woods[w] = sc.nextInt();
      }


      int ret = solve(0, woodN - 1);

      System.out.println(ret);
    }
    sc.close();
  }

  private static int solve(int start, int end) {

    if(end  == start) return woods[start];
    int half = (start + end)/2;

    int ret = Math.max(solve(start, half), solve(half + 1, end));

    int lo = half, hi = half + 1;
    int height = Math.min(woods[lo], woods[hi]);

    ret = Math.max(ret, height * 2);

    while( lo > start || hi < end ) {
      if( lo > start && ( hi == end || woods[lo-1] > woods[hi+1])) {
        lo--;
        height = Math.min(height, woods[lo]);
      } else {
        hi++;
        height = Math.min(height, woods[hi]);
      }
      ret = Math.max(ret, height * (hi - lo +1));
    }
    return ret;
  }
}
