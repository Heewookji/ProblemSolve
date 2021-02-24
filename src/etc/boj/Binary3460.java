package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary3460 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int pos = 0;
      while (n > 0) {
        if (n % 2 == 1) System.out.print(pos + " ");
        n /= 2;
        pos++;
      }
      System.out.println();
    }
  }
}