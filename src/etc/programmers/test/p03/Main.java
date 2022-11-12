package etc.programmers.test.p03;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  /**
   * 퀘스트 5개, 3번을 완수하려면 1번을 먼저 해결해야한다, 리턴값은 퀘스트 순서, 12354
   */
  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        Arrays.toString(solution.solution(5, new int[][]{{1, 3}, {1, 4}, {3, 5}, {5, 4}})));
  }
}

class Solution {

  public int[] solution(int n, int[][] quests) {
    ArrayList<Integer> solvedList = new ArrayList<>();
    recursive(1, n, quests, solvedList);
    return solvedList.stream().mapToInt(Integer::intValue).toArray();
  }

  public void recursive(int target, int n, int[][] quests, ArrayList<Integer> solvedQuests) {
    ArrayList<Integer> requiredQuests = requiredQuests(quests, target);
    if (requiredQuests.size() > 0) {
      for (int requiredQuest : requiredQuests) {
        if (solvedQuests.contains(requiredQuest)) {
          continue;
        }
        recursive(requiredQuest, n, quests, solvedQuests);
      }
    }
    solvedQuests.add(target);
    int nextQuest = -1;
    for (int quest = 1; quest <= n; quest++) {
      if (!solvedQuests.contains(quest)) {
        nextQuest = quest;
      }
    }
    if (nextQuest == -1) {
      return;
    }
    recursive(nextQuest, n, quests, solvedQuests);
  }

  ArrayList<Integer> requiredQuests(int[][] quests, int target) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int[] quest : quests) {
      if (target == quest[1]) {
        list.add(quest[0]);
      }
    }
    return list;
  }
}