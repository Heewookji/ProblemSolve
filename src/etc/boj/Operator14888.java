package etc.boj;

import java.util.Scanner;

public class Operator14888 {

  static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] list = new int[n];
    int[] operator = new int[4];
    for (int i = 0; i < n; i++)
      list[i] = sc.nextInt();
    for (int i = 0; i < 4; i++)
      operator[i] = sc.nextInt();
    recursive(0, list, operator, list[0]);
    System.out.println(max);
    System.out.println(min);
  }

  private static void recursive(int index, int[] list, int[] operator, int ret) {
    if (index == list.length - 1) {
      max = Math.max(ret, max);
      min = Math.min(ret, min);
      return;
    }
    for (int i = 0; i < operator.length; i++) {
      if (operator[i] == 0) continue;
      operator[i]--;
      recursive(index + 1, list, operator, calculate(ret, list[index + 1], i));
      operator[i]++;
    }
  }

  private static int calculate(int num1, int num2, int operator) {
    int ret = 0;
    switch (operator) {
      case 0:
        ret = num1 + num2;
        break;
      case 1:
        ret = num1 - num2;
        break;
      case 2:
        ret = num1 * num2;
        break;
      case 3:
        ret = num1 / num2;
        break;
    }
    return ret;
  }
}
