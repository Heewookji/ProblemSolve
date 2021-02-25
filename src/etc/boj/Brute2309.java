package etc.boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Brute2309 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] list = new int[9];
    ArrayList<Integer> retList = new ArrayList<Integer>();
    for (int i = 0; i < 9; i++)
      list[i] = sc.nextInt();
    recursive(list, retList, 0, 0);
    Collections.sort(retList);
    retList.forEach(n -> System.out.println(n));
  }

  private static boolean recursive(int[] list, ArrayList<Integer> retList, int sum, int index) {
    if (retList.size() == 7)
      return sum == 100 ? true : false;
    for (int i = index; i < list.length; i++) {
      retList.add(list[i]);
      if (recursive(list, retList, sum + list[i], i + 1))
        return true;
      retList.remove(retList.size() - 1);
    }
    return false;
  }
}
