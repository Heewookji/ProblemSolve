package p14pi;

import java.util.Scanner;

public class Main2 {

  static final int MAX = Integer.MAX_VALUE;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();
    sc.nextLine();

    for (int i = 0; i < testN; i++) {
      char[] line = sc.nextLine().toCharArray();
      int[] numbers = new int[line.length];
      for (int j = 0; j < line.length; j++)
        numbers[j] = line[j] - '0';
      System.out.println(recursive(numbers, 0, numbers.length - 1, new int[numbers.length]));
    }
  }

  private static int recursive(int[] numbers, int start, int end, int[] cache) {

    if (3 <= end - start + 1 && end - start + 1 <= 5)
      return caculate(numbers, start, end);
      
    if (end - start + 1 < 3)
      return MAX;

    if (cache[start] != 0)
      return cache[start];

    int ret = MAX;

    int a = caculate(numbers, start, start + 2) + recursive(numbers, start + 3, end, cache);
    int b = caculate(numbers, start, start + 3) + recursive(numbers, start + 4, end, cache);
    int c = caculate(numbers, start, start + 4) + recursive(numbers, start + 5, end, cache);


    ret = Math.min(Math.min(a < 0 ? MAX : a, b < 0 ? MAX : b), c < 0 ? MAX : c);

    return cache[start] = ret;
  }

  private static int caculate(int[] numbers, int start, int end) {


    boolean a = true, b = true, c = true, d = true;
    int dDiff = numbers[start + 1] - numbers[start];
    boolean bPlusFlag = dDiff <= 0 ? false : true, bMinusFlag = dDiff >= 0 ? false : true;
    if (!bPlusFlag && !bMinusFlag)
      b = false;

    for (int i = start; i < end; i++) {
      if (numbers[i] != numbers[i + 1])
        a = false;
      if (bPlusFlag && numbers[i] + 1 != numbers[i + 1]) {
        bMinusFlag = false;
        b = false;
      }
      if (bMinusFlag && numbers[i] != numbers[i + 1] + 1) {
        bPlusFlag = false;
        b = false;
      }
      if (numbers[i + 1] - numbers[i] != dDiff)
        d = false;
    }
    if (a)
      return 1;
    if (b)
      return 2;

    for (int i = start; i <= end; i++) {
      if ((i - start) % 2 == 0 && numbers[i] != numbers[start])
        c = false;
      else if ((i - start) % 2 == 1 && numbers[i] != numbers[start + 1])
        c = false;
    }
    
    if (c)
      return 4;
    if (d)
      return 5;

    return 10;
  }

}

