package etc.programmers.test10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class One {
  public int solution(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    while (n > 0) {
      list.add(n % 3);
      n /= 3;
    }
    n = 1;
    int sum = 0;
    for (int i = list.size() - 1; i >= 0; i--) {
      sum += n * list.get(i);
      n *= 3;
    }
    return sum;
  }

  public int solution2(int n) {
    Queue<Integer> q = new LinkedList<>();
    while (n != 0) {
      q.add(n % 3);
      n /= 3;
    }
    while (!q.isEmpty()) {
      n *= 3;
      n += q.poll();
    }
    return n;
  }
}