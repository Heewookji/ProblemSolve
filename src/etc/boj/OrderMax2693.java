package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class OrderMax2693 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      ArrayList<Integer> list = new ArrayList<>();
      while (st.hasMoreTokens())
        list.add(Integer.parseInt(st.nextToken()));
      Collections.sort(list);
      System.out.println(list.get(7));
    }
  }
}
