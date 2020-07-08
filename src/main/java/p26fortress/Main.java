package p26fortress;

import java.util.ArrayList;
import java.util.Scanner;

class Wall {

  private int x;
  private int y;
  private int r;

  public Wall(int x, int y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  @Override
  public String toString() {
    return "x = " + this.x + " y = " + this.y + " r = " + this.r;
  }

  public int countDistance(Wall another) {

    return 0;
  }

}

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      ArrayList<Wall> list = new ArrayList<>();
      for (int j = 0; j < n; j++)
        list.add(new Wall(sc.nextInt(), sc.nextInt(), sc.nextInt()));
      int ret = 0;
      for (int one = 0; one < list.size(); one++)
        for (int another = one + 1; another < list.size(); another++)
          ret = Math.max(ret, list.get(one).countDistance(list.get(another)));
    }

  }
}