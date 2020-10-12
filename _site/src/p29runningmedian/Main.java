package p29runningmedian;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

  private static int[] init(int n, long a, long b) {
    int[] ret = new int[n];
    ret[0] = 1983;
    for (int i = 1; i < n; i++)
      ret[i] = (int)((ret[i - 1] * a + b) % 20090711);
    return ret;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();
    for (int i = 0; i < testN; i++) {
      int ret = 0;
      int[] arr = init(sc.nextInt(), sc.nextInt(), sc.nextInt());
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      for (int cnt = 1; cnt <= arr.length; cnt++) {
        if (minHeap.size() == maxHeap.size())
          maxHeap.offer(arr[cnt - 1]);
        else
          minHeap.offer(arr[cnt - 1]);
        if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
          int a = maxHeap.peek();
          int b = minHeap.peek();
          maxHeap.poll();
          minHeap.poll();
          maxHeap.offer(b);
          minHeap.offer(a);
        }
        ret = (ret + maxHeap.peek()) % 20090711;
      }
      System.out.println(ret);
    }
  }
}