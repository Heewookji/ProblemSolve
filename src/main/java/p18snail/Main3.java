package p18snail;

import java.util.Scanner;

public class Main3 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {

      int depth = sc.nextInt();
      int day = sc.nextInt();
      int[][] cache = new int[depth + 1][day + 1];

      System.out.println(find(depth, day, cache));

    }
  }

  private static double find(int depth, int day, int[][] cache) {

    if (depth <= 0)
      return 1;
    else if (day == 0)
      return 0;
    if (cache[depth][day] != -1)
      return cache[depth][day];

    return cache[depth][day] = find(depth - 2, day - 1) * 0.75 + find(depth - 1, day - 1) * 0.25;
  }
}
