package p30dictionary;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      sc.nextLine();
      boolean[][] relation = new boolean[26][26];
      String[] words = new String[n];

      for (int j = 0; j < n; j++)
        words[j] = sc.nextLine();

      makeGraph(words, relation);
      LinkedList<Integer> dictionary = getOrder(relation);
      
      if (dictionary.size() == 0)
        System.out.println("INVALID HYPOTHESIS");
      else
        for (int j = 0; j < dictionary.size(); j++)
          System.out.print(Character.toChars(dictionary.get(j) + 'a'));
      System.out.println();
    }
  }

  private static void makeGraph(String[] words, boolean[][] relation) {
    for (int next = 1; next < words.length; next++) {
      int now = next - 1;
      int min = Math.min(words[now].length(), words[next].length());
      for (int i = 0; i < min; i++) {
        if (words[now].charAt(i) != words[next].charAt(i)) {
          int a = words[now].charAt(i) - 'a';
          int b = words[next].charAt(i) - 'a';
          relation[a][b] = true;
          break;
        }
      }
    }
  }

  private static LinkedList<Integer> getOrder(final boolean[][] relation) {
    LinkedList<Integer> dictionary = new LinkedList<>();
    boolean[] visited = new boolean[relation.length];

    for (int i = 0; i < relation.length; i++)
      if (!visited[i])
        dfs(i, relation, visited, dictionary);
    Collections.reverse(dictionary);

    for (int now = 0; now < relation.length; now++)
      for (int next = now + 1; next < relation.length; next++)
        if (relation[dictionary.get(next)][dictionary.get(now)])
          return new LinkedList<>();
    return dictionary;
  }

  private static void dfs(int now, final boolean[][] relation, boolean[] visited, LinkedList<Integer> dictionary) {
    visited[now] = true;
    for (int next = 0; next < relation.length; next++)
      if (relation[now][next] && !visited[next])
        dfs(next, relation, visited, dictionary);
    dictionary.offer(now);
  }
}