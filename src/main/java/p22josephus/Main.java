package p22josephus;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {

      int n = sc.nextInt();
      int term = sc.nextInt();
      ArrayList<Integer> ret = new ArrayList<>();
      for (int j = 1; j <= n; j++)
        ret.add(j);
      find(n, term, ret);
      System.out.println(ret.get(0) + " " + ret.get(1));

    }

  }

  private static void find(int n, int term, ArrayList<Integer> ret) {

    int die = 0;
    while (ret.size() != 2) {
      die %= ret.size();
      ret.remove(die);
      die += term - 1;
    }
  }

}
