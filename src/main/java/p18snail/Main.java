package p18snail;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  static int depth;
  static double[][] cache = new double[1000+1][1000+2];

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      depth = sc.nextInt();
      int day = sc.nextInt();
      for(double[] c : cache) Arrays.fill(c, -1);
      double ret = find(day, 0);

      System.out.printf("%.10f%n", ret);
    }
  }

  private static double find(int day, int curDepth) {
    if(curDepth >= depth) return 1;
    if(day == 0) return 0;
    if(cache[day][curDepth] != -1) return cache[day][curDepth];
    return cache[day][curDepth] = (0.75 * find(day-1, curDepth+2)) + (0.25 * find(day-1, curDepth+1));
  }

}
