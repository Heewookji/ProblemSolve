package quadtree;

import java.util.Scanner;

public class Main {

  static String[][] board;
  
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t<testN; t++) {
      String line = sc.nextLine();
      board = new String[16][16];
      draw(line);

      for(int i=0; i<16; i++) {
        for(int j=0; j<16; j++) {
          System.out.print(board[i][j]);
        }
        System.out.println();
      }
    }
  }
  
  private static void draw(String line) {
    
    char head = line.charAt(0);
    if(head == 'w' || head == 'b' ) {
      
    }
    
  }

}
