package etc.programmers.test10;

public class Four {

  public long solution(String s) {
    long answer = 0;
    for (int i = 0; i < s.length(); i++)
      for (int j = 1; i + j <= s.length(); j++)
        answer += find(s, i, i + j);
    return answer;
  }

  private long find(String s, int start, int end) {
    long ret = -1;
    boolean flag = false;
    for (int i = start; i < end - 1; i++) {
      for (int j = end - 1; j > i; j--) {
        if (j - i <= ret)
          break;
        if (s.charAt(i) != s.charAt(j)) {
          flag = true;
          ret = Math.max(ret, j - i);
        }
      }
    }
    return !flag ? 0 : ret;
  }
}