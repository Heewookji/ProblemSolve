package etc.programmers.school.p04;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        Arrays.toString(solution.solution(3,
                new String[]{
                    "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
                }
            )
        )
    );
  }
}

class Solution {

  public int[] solution(int n, String[] words) {
    HashSet<String> usedWords = new HashSet<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      int no = i % n + 1;
      int round = i / n + 1;
      if (i != 0 && isInvalid(word, usedWords, words[i - 1])) {
        return new int[]{no, round};
      }
      usedWords.add(word);
    }
    return new int[]{0, 0};
  }

  public boolean isInvalid(String word, HashSet<String> usedWords, String lastUsedWord) {
    return !usedWords.isEmpty() && (usedWords.contains(word)
        || word.charAt(0) != lastUsedWord.charAt(lastUsedWord.length() - 1));
  }
}
