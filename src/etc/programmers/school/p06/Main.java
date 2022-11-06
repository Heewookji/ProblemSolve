package etc.programmers.school.p06;


import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        Arrays.toString(
            solution.solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{
                    {2, 5, 3},
                    {4, 4, 1},
                    {1, 7, 3}
                })));
  }
}

class Solution {

  public int[] solution(int[] array, int[][] commands) {
    int[] answer = new int[commands.length];
    for (int i = 0; i < commands.length; i++) {
      int[] command = commands[i];
      int[] splicedArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
      Arrays.sort(splicedArray);
      answer[i] = splicedArray[command[2] - 1];
    }
    return answer;
  }

}