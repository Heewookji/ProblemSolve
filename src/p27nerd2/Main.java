package p27nerd2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testN = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < testN; i++) {
      int n = Integer.parseInt(br.readLine());
      TreeMap<Integer, Integer> binTree = new TreeMap<>();
      int sum = 0;
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine(), " ");
        sum += find(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), binTree);
      }
      System.out.println(sum);
    }
  }

  private static boolean isDominated(int x, int y, TreeMap<Integer, Integer> binTree) {
    Integer higherX = binTree.higherKey(x);
    if (higherX == null)
      return false;
    return y < binTree.get(higherX);
  }

  private static void removeDominated(int x, int y, TreeMap<Integer, Integer> binTree) {
    ArrayList<Integer> keyList = new ArrayList<>(binTree.headMap(x).keySet());
    if (keyList.size() == 0)
      return;
    for (int i = keyList.size() - 1; i >= 0; i--) {
      int key = keyList.get(i);
      if (binTree.get(key) < y)
        binTree.remove(key);
      else
        break;
    }
  }

  private static int find(int x, int y, TreeMap<Integer, Integer> binTree) {
    if (isDominated(x, y, binTree))
      return binTree.size();
    removeDominated(x, y, binTree);
    binTree.put(x, y);
    return binTree.size();
  }

}