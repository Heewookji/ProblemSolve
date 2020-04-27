package ㅡ06quadtree;

import java.util.Scanner;

public class Main {

  static int point;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t< testN; t++) {
      String line = sc.nextLine();
      point = 0;
      String ret = reverse(line);
      System.out.println(ret);
    }
    sc.close();
  }

  public static String reverse(String line) {
    char head = line.charAt(point);
    point++;
    if(head == 'b' || head == 'w') {
      return String.valueOf(head);
    }
    else {
      String upperLeft = reverse(line);
      String upperRight = reverse(line);
      String lowerLeft = reverse(line);
      String lowerRight = reverse(line);

      return "x" + lowerLeft + lowerRight + upperLeft + upperRight; 
    }
  }
}