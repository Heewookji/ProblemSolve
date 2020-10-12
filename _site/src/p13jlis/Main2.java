package p13jlis;

import java.util.Scanner;

public class Main2 {

  static int[] aList;
  static int[] bList;
  static int[][] cache;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      input(sc);
      System.out.println(recursive(-1, -1) - 2);
    }
  }

  private static int recursive(int indexA, int indexB) {

    if (cache[indexA + 1][indexB + 1] != 0)
      return cache[indexA + 1][indexB + 1];

    int a = (indexA == -1 ? Integer.MIN_VALUE : aList[indexA]);
    int b = (indexB == -1 ? Integer.MIN_VALUE : bList[indexB]);
    int max = Math.max(a, b);

    int ret = 2;
    for (int nextA = indexA + 1; nextA < aList.length; nextA++) {
      if (aList[nextA] > max)
        ret = Math.max(ret, recursive(nextA, indexB) + 1);
    }
    for (int nextB = indexB + 1; nextB < bList.length; nextB++) {
      if (bList[nextB] > max)
        ret = Math.max(ret, recursive(indexA, nextB) + 1);
    }
    return cache[indexA + 1][indexB + 1] = ret;
  }

  private static void input(Scanner sc) {

    int aN = sc.nextInt();
    int bN = sc.nextInt();
    aList = new int[aN];
    bList = new int[bN];
    cache = new int[aN + 1][bN + 1];

    for (int a = 0; a < aN; a++)
      aList[a] = sc.nextInt();
    for (int b = 0; b < bN; b++)
      bList[b] = sc.nextInt();
  }

}
