package etc.programmers.school.p07;


import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        Arrays.toString(
            solution.solution(new String[]{"abce", "abcd", "cdx"}, 1)
        )
    );
  }
}

class Solution {

  public String[] solution(String[] strings, int n) {
    Arrays.sort(strings, (o1, o2) -> {
      if (o1.charAt(n) == o2.charAt(n)) {
        return o1.compareTo(o2);
      }
      return o1.charAt(n) - o2.charAt(n);
    });
    return strings;
  }
}