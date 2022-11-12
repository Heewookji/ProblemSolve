package etc.programmers.test.p04;

public class Main {

  /**
   * 팩토리얼의 끝 0 개수 구하기, 시간 초과
   */
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution(3));
  }
}

class Solution {

  public int solution(int n) {
    if (n == 0) {
      return 0;
    }
    int result = recursive(n, new int[n + 1]);
    int count = 0;
    while (result % 10 == 0) {
      count++;
      result /= 10;
    }
    return count;
  }

  int recursive(int n, int[] cache) {
    if (n == 1) {
      return 1;
    }
    if (cache[n] > 0) {
      return cache[n];
    }
    cache[n] = n * recursive(n - 1, cache);
    return cache[n];
  }
}