package ㅡetc;

import java.util.Scanner;

public class Dart {
  
  static String line;
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    sc.nextLine();
    
    for(int t=0; t<testN; t++) {
      line = sc.nextLine();
      
      System.out.println(find(line));
    }
  }
  
  private static int find(String line) {
    
    int score = 0;
    int[] scores = new int[3];
    
  }
  private static int score(int start, int end) {
    
    for(int i=0; i<line.length(); i++) {
      if(line.charAt(i) != 'S' || line.charAt(i) != 'D' || line.charAt(i) != 'T' || line.charAt(i) != '*' || line.charAt(i) != '#')
      
    }
    return 0;
  }

}
