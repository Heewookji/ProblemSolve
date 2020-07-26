package p07fence;

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

    if(start == end) return fence[start];
    int half = (end-start)/2 + start;
    int max = Math.max(find(half+1, end), find(start, half));
    
    int lo = half, hi = half+1;
    int least = Math.min(fence[lo], fence[hi]);
    max = Math.max(max, least*2);
    
    while(start<lo || end>hi) {
      if(start<lo && (hi == end || fence[lo-1] > fence[hi+1])) {
        lo--;
        least = Math.min(least, fence[lo]);
      }else {
        hi++;
        least = Math.min(least, fence[hi]);
      }
      max = Math.max(max, least*(hi-lo+1));
    }
    return max;
  }
}
