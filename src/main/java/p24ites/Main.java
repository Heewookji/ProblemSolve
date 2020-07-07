package p024ites;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class RNG {

  private long seed;

  public RNG(long seed) {
    this.seed = seed;
  }

  public int generate() {
    int ret = (int) (this.seed % 10000) + 1;
    this.seed = (this.seed * 214013 + 2531011) % (long) Math.pow(2, 32);
    return ret;
  }

}

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int target = sc.nextInt();
      int n = sc.nextInt();
      System.out.println(find(target, n, new RNG(1983), new LinkedList<>()));
    }

  }

  private static int find(int target, final int n, RNG generator, Queue<Integer> que) {

    int ret = 0, rangeSum = 0;
    for (int i = 0; i < n; i++) {
      int newSignal = generator.generate();
      rangeSum += newSignal;
      que.offer(newSignal);

      while (rangeSum > target) {
        rangeSum -= que.peek();
        que.poll();
      }
      if (rangeSum == target)
        ret++;
    }
    return ret;
  }

}