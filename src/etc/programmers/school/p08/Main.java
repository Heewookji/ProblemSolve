package etc.programmers.school.p08;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
  }
}

class Solution {

  public int solution(String skill, String[] skill_trees) {
    int count = 0;
    for (String skill_tree : skill_trees) {
      count += validate(skill, skill_tree);
    }
    return count;
  }

  int validate(String skill, String skill_tree) {
    for (int i = 0; i < skill.length(); i++) {
      for (int j = i + 1; j < skill.length(); j++) {
        int firstIndex = skill_tree.indexOf(skill.charAt(i));
        int secondIndex = skill_tree.indexOf(skill.charAt(j));
        if (secondIndex < 0) {
          continue;
        }
        if (firstIndex < 0 || firstIndex > secondIndex) {
          return 0;
        }
      }
    }
    return 1;
  }
}