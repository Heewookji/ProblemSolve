package p23brackets2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < testN; i++) {
      String line = sc.nextLine();
      System.out.println(caculate(line) ? "YES" : "NO");
    }

  }

  private static boolean caculate(String line) {

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < line.length(); i++) {
      char now = line.charAt(i);
      if (now == '(' || now == '{' || now == '[')
        stack.push(now);
      else if (stack.size() != 0) {
        char past = stack.pop();
        if ((past == '(' && now != ')') || (past == '{' && now != '}') || (past == '[' && now != ']'))
          return false;
      } else
        return false;
    }
    return stack.size() == 0;
  }
}