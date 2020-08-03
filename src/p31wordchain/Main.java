package p31wordchain;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      sc.nextLine();
      String[] words = new String[n];
      ArrayList<String> used = new ArrayList<>();
      for (int j = 0; j < n; j++)
        words[j] = sc.nextLine();

      boolean flag = false;
      for (int j = 0; j < n; j++) {
        if (find(words, words[j].charAt(words[j].length() - 1), used)) {
          flag = true;
          break;
        }
      }
      if (!flag)
        System.out.println("IMPOSSIBLE");
    }
    sc.close();
  }

  private static boolean find(final String[] words, final char pastChar, ArrayList<String> used) {

    if (used.size() == words.length) {
      for (String s : used)
        System.out.print(s + " ");
      System.out.println();
      return true;
    }
    for (int next = 0; next < words.length; next++) {
      String nextWord = words[next];
      if (pastChar != nextWord.charAt(0) || used.contains(words[next]))
        continue;
      used.add(nextWord);
      if (find(words, nextWord.charAt(nextWord.length() - 1), used))
        return true;
      used.remove(used.size() - 1);
    }
    return false;
  }

}