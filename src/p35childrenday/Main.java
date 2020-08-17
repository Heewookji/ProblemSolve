package p35childrenday;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {

    Scanner scanner = new Scanner(System.in);
    int caseN = scanner.nextInt();
    for (int i = 0; i < caseN; i++) {
      ArrayList<Integer> numbers = makeNumbers(scanner.nextInt());
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      int ans = solve(numbers, n, m);
      System.out.println(ans != -1 ? ans : "IMPOSSIBLE");
    }
  }

  private static ArrayList<Integer> makeNumbers(int numbers) {
    ArrayList<Integer> ret = new ArrayList<>();
    int result = 0;
    while (numbers > 0) {
      result = result * 10 + numbers % 10;
      numbers /= 10;
    }
    while (result > 0) {
      ret.add(result % 10);
      result /= 10;
    }
    return ret;
  }

  private static int solve(ArrayList<Integer> numbers, int n, int m) {
    return -1;
  }

}