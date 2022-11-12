package etc.programmers.test.p01;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.solution(
        new String[]{"world", "prog"},
        new String[]{"hello", "world", "code", "hello", "try", "code"}
    )));
  }
}

class Solution {

  public String[] solution(String[] teamIDs, String[] additional) {
    LinkedHashSet<String> used = new LinkedHashSet<>();

    for (String id : additional) {
      if (!isAlreadyExist(id, teamIDs)) {
        used.add(id);
      }
    }
    return used.toArray(new String[]{});
  }

  boolean isAlreadyExist(String id, String[] teamIDs) {
    for (String existID : teamIDs) {
      if (Objects.equals(id, existID)) {
        return true;
      }
    }
    return false;
  }
}
