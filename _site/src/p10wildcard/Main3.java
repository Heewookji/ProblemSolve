package p10wildcard;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main3 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < testN; i++) {

      String wildString = sc.nextLine();
      int n = sc.nextInt();
      sc.nextLine();
      Queue<String> ret = new PriorityQueue<>();
      for (int j = 0; j < n; j++) {
        String word = sc.nextLine();
        if (find(wildString, word, 0, 0, new int[wildString.length() + 1][word.length() + 1]) == 1)
          ret.add(word);
      }
      while (ret.size() != 0)
        System.out.println(ret.poll());
    }
  }

  private static int find(String wildString, String word, int wildN, int wordN, int[][] cache) {

    if (cache[wildN][wordN] != 0)
      return cache[wildN][wordN];

    while (wildN < wildString.length() && wordN < word.length()
        && (wildString.charAt(wildN) == '?' || wildString.charAt(wildN) == word.charAt(wordN))) {
      wildN++;
      wordN++;
    }
    if (wildN == wildString.length())
      return cache[wildN][wordN] = (wordN == word.length() ? 1 : -1);

    if (wildString.charAt(wildN) == '*')
      for (int i = 0; i <= word.length() - wordN; i++)
        if (find(wildString, word, wildN + 1, wordN + i, cache) == 1)
          return cache[wildN][wordN] = 1;

    return cache[wildN][wordN] = -1;
  }
}
