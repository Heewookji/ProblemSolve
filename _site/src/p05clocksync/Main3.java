package p05clocksync;

import java.util.Scanner;

public class Main3 {

  static final int[][] switches = { { 0, 1, 2 }, { 3, 7, 9, 11 }, { 4, 10, 14, 15 }, { 0, 4, 5, 6, 7 },
      { 6, 7, 8, 10, 12 }, { 0, 2, 14, 15 }, { 3, 14, 15 }, { 4, 5, 7, 14, 15 }, { 1, 2, 3, 4, 5 },
      { 3, 4, 5, 9, 13 } };
  static final int MAX = Integer.MAX_VALUE;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int[] clocks = new int[16];
    int testN = sc.nextInt();
    int ret = MAX;

    for (int i = 0; i < testN; i++) {
      for (int c = 0; c < 16; c++)
        clocks[c] = sc.nextInt();
      ret = recursive(clocks, 0, 0);
      System.out.println(ret == MAX ? -1 : ret);
    }
  }

  private static int recursive(int[] clocks, int clickN, int switchN) {

    if (isCorrect(clocks))
      return clickN;
    if (switchN == switches.length)
      return MAX;

    int ret = MAX;

    for (int i = 0; i < 4; i++) {
      ret = Math.min(ret, recursive(clocks, clickN + i, switchN + 1));
      click(clocks, switchN);
    }
    return ret;
  }

  private static boolean isCorrect(int[] clocks) {
    for (int i = 0; i < clocks.length; i++)
      if (clocks[i] != 12)
        return false;
    return true;
  }

  private static void click(int[] clocks, int switchN) {
    for (int i : switches[switchN])
      if ((clocks[i] += 3) > 12)
        clocks[i] = 3;
  }

}
