package etc.programmers.test.p02;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.solution("xyZA", "ABCxy"));
  }
}

class Solution {

  public String solution(String s1, String s2) {
    int count1 = getSplitCount(s1, s2);
    int count2 = getSplitCount(s2, s1);
    String string1 = joinString(count1, s1, s2);
    String string2 = joinString(count2, s2, s1);
    return getShortString(string1, string2);
  }

  int getSplitCount(String s1, String s2) {
    int length = Math.max(s1.length(), s2.length());
    for (int point = 0; point < length; point++) {
      String prefix = s1.substring(point);
      if (s2.startsWith(prefix)) {
        return s1.length() - point;
      }
    }
    return 0;
  }

  String joinString(int count, String s1, String s2) {
    return s1 + s2.substring(count);
  }

  String getShortString(String s1, String s2) {
    if (s1.length() == s2.length()) {
      return s1.compareTo(s2) <= 0 ? s1 : s2;
    }
    return s1.length() < s2.length() ? s1 : s2;
  }
}
