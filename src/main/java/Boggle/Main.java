package Boggle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  static int[] dx = {1,1,0,-1,-1,-1,0,1};
  static int[] dy = {0,1,1,1,0,-1,-1,-1};
  static char[][] boggle = new char[5][5];
  static HashMap<String, Boolean> cache = null; 


  public static void main(String[] args) throws IOException {

    Scanner keyboard = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int caseNum = keyboard.nextInt();
    keyboard.nextLine();

    for(int i=0; i<caseNum; i++) {

      cache = new HashMap<String,Boolean>();
      for(int y=0; y<5; y++) {
        boggle[y] = keyboard.nextLine().toCharArray();
      }

      int wordNum = keyboard.nextInt();
      keyboard.nextLine();
      String[] keywords = new String[wordNum];

      for(int j=0;j<wordNum;j++) {
        keywords[j] = keyboard.nextLine();
      }

      for(int j=0;j<wordNum;j++) {
        boolean flag = false;
        find: for(int y=0; y<5; y++) {
          for(int x=0; x<5; x++) {
            if(find(x,y,keywords[j])) {
              flag = true;
              break find;
            }
          }
        }
        sb.append(keywords[j]+" "+(flag?"YES\n":"NO\n"));
      }
    }
    System.out.print(sb);
    keyboard.close();
  }

  private static boolean find(int x, int y, String keyword) {

    if(x>4||x<0||y>4||y<0) return false;
    if(boggle[x][y] != keyword.charAt(0)) return false;
    if(keyword.length() == 1) return true;

    for(int eightWay=0;eightWay<8;eightWay++) {
      int nextX = x+dx[eightWay];
      int nextY = y+dy[eightWay];
      String nextKeyword = keyword.substring(1);
      Boolean cacheFlag = cache.get(nextX+","+nextY+","+nextKeyword);

      if(cacheFlag != null && cacheFlag) {
        return true;
      } else if(cacheFlag != null && !cacheFlag) {
        return false;
      }

      if(find(nextX,nextY,nextKeyword)) {
        cache.put(nextX+","+nextY+","+nextKeyword, true );
        return true;
      }
    }
    cache.put(x+","+y+","+keyword, false);
    return false;
  }

}
