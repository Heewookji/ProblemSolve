package etc.programmers.test10;

import java.util.ArrayList;

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
}