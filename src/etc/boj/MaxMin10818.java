package etc.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxMin10818 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    StringTokenizer st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      int num = Integer.parseInt(st.nextToken());
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    System.out.println(min + " " + max);
  }
}
