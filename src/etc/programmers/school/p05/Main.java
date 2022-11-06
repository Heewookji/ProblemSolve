package etc.programmers.school.p05;


public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        solution.solution(new int[]{1, 2, 7, 6, 4})
    );
  }
}

class Solution {

  public int solution(int[] nums) {
    return recursive(0, 3, nums, 0);
  }

  int recursive(int start, int remain, int[] nums, int sum) {
    if (remain == 0) {
      return isPrimary(sum) ? 1 : 0;
    }
    int count = 0;
    for (int i = start; i < nums.length; i++) {
      count += recursive(i + 1, remain - 1, nums, sum + nums[i]);
    }
    return count;
  }

  boolean isPrimary(int num) {
    int temp = 2;
    double i = Math.sqrt(num);
    while (temp <= i) {
      if (num % temp == 0) {
        return false;
      }
      temp++;
    }
    return true;
  }
}