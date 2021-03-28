package etc.boj;

import java.util.Scanner;

class Simulation14719 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int H = sc.nextInt();
    int W = sc.nextInt();
    boolean[][] arr = new boolean[W][H];
    for (int i = 0; i < W; i++) {
      int h = sc.nextInt();
      for (int j = 0; j < h; j++)
        arr[i][j] = true;
    }
    int sum = 0;
    for (int j = 0; j < H; j++) {
      int pastI = -1;
      for (int i = 0; i < W; i++) {
        if (arr[i][j]) {
          if (pastI != -1)
            sum += i - pastI - 1;
          pastI = i;
        }
      }
    }
    System.out.println(sum);
  }
}