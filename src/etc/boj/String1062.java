package etc.boj;

import java.util.HashSet;
import java.util.Scanner;

public class String1062 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    sc.nextLine();
    String[] words = new String[N];
    HashSet<String> usedAlphabetSet = new HashSet<>();
    String[] usedAlphabet;
    for (int i = 0; i < N; i++) {
      words[i] = cutString(sc.nextLine());
      for (char c : words[i].toCharArray())
        usedAlphabetSet.add(String.valueOf(c));
    }
    usedAlphabet = usedAlphabetSet.toArray(new String[usedAlphabetSet.size()]);
    if (K - 5 < 0) System.out.print(0);
    else System.out.print(recursive(words, usedAlphabet, 0, K - 5, ""));
  }

  private static String cutString(String word) {
    return word.replaceAll("a", "").
            replaceAll("n", "").
            replaceAll("t", "").
            replaceAll("i", "").
            replaceAll("c", "");
  }

  private static int recursive(String[] words, String[] usedAlphabet, int index, int n, String now) {
    if (now.length() == n || index == usedAlphabet.length)
      return calculate(now, words);
    int ret = Integer.MIN_VALUE;
    for (int i = index; i < usedAlphabet.length; i++)
      ret = Math.max(ret, recursive(words, usedAlphabet, i + 1, n, now + usedAlphabet[i]));
    return ret;
  }

  private static int calculate(String now, String[] words) {
    int count = 0;
    for (String word : words) {
      boolean flag = true;
      for (char c : word.toCharArray()) {
        if (now.indexOf(c) == -1) {
          flag = false;
          break;
        }
      }
      if (flag)
        count++;
    }
    return count;
  }

}
