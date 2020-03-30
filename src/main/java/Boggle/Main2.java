package Boggle;

import java.util.Scanner;

public class Main2 {

  static char[][] board = new char[5][5];
  static int[] dx = {1,1,1,0,0,-1,-1,-1};
  static int[] dy = {0,1,-1,1,-1,1,0,-1};

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int caseN = in.nextInt();
    in.nextLine();

    for(int n=0; n<caseN; n++) {

      String boardText = "";
      for(int y=0; y<5; y++) {
        String line = in.nextLine();
        board[y] = line.toCharArray();
        boardText += line;
      }

      int keywordN = in.nextInt();
      in.nextLine();

      for(int k=0; k<keywordN; k++) {

        String keyword = in.nextLine();
        boolean exist = true;

        for(int i=0; i<keyword.length(); i++) {
          if(boardText.indexOf(keyword.charAt(i)) == -1) {
            exist = false;
            break;
          }
        }

        boolean result = false;
        if(exist) {
          loop: for(int y=0; y<5; y++) {
            for(int x=0; x<5; x++) {
              result = find(x,y,keyword);
              if(result == true) break loop;
            }
          }
        }
        
        System.out.println(keyword+ " " + (result?"YES":"NO"));
      }
    }
    in.close();
  }

  private static boolean find(int x, int y, String keyword) {

    if(x<0||x>4||y<0||y>4) return false;
    if(keyword.charAt(0) != board[x][y]) return false;
    if(keyword.length() == 1) return true;
    for(int i=0; i<8; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];
      if(find(nextX,nextY, keyword.substring(1))){
        return true;
      }
    }
    return false;
  }
}




