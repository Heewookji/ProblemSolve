package etc.boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Sum1292 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i < 500; i++)
      for (int j = 1; j <= i; j++)
        list.add(i);
    int sum = 0;
    for (int i = A; i <= B; i++)
      sum += list.get(i - 1);
    System.out.println(sum);
  }
}
