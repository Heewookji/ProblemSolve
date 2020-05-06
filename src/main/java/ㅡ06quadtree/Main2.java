package ㅡ06quadtree;

import java.util.Scanner;

public class Main2 {
  
  static int point = 0;
  static String line;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t<testN; t++) {
      line = sc.nextLine();
      point = 0;
      System.out.println(find());
    }
  }

  private static String find() {
    
    char head = line.charAt(point);
    point++;
    if(head == 'w' || head == 'b') {
      return String.valueOf(head);
    }
    String one = find();
    String two = find();
    String three = find();
    String four = find();
    return "x" + three + four + one + two;  
  }

}
