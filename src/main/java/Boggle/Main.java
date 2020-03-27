package Boggle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  static char[][] boggle = null;
  static int[][] eightWays = {
      {0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}
  };
  static Map<String, int[]> cache = new HashMap<String, int[]>();

  public static void main(String[] args) throws IOException {

    Scanner keyboard = new Scanner(System.in);

    int testCase = keyboard.nextInt();
    keyboard.nextLine();
    boggle = new char[5][5];


    for(int tc=0; tc < testCase; tc++) {

      for(int y=0; y<5; y++) {
        String line = keyboard.nextLine();
        for(int x=0; x<5; x++) {
          boggle[x][y] = line.charAt(x);
        }
      }

      int wordNumber = keyboard.nextInt();
      keyboard.nextLine();
      String[] keywords = new String[wordNumber];

      for(int i=0; i<wordNumber; i++) {
        keywords[i] = keyboard.nextLine();
      }

      for(int i=0; i<wordNumber; i++) {
        boolean flag = false;
        label:for(int y=0; y<5; y++) {
          for(int x=0; x<5; x++) {
            if(boggle[x][y] == keywords[i].charAt(0)) {
              flag = find(x,y,keywords[i],1);
              if(flag) break label;
            }
          }
        }
        System.out.println(keywords[i]+" "+(flag? "YES":"NO"));
      }
    }
    keyboard.close();
  }


  private static boolean find(int x, int y, String keyword, int pos) {

    int newX = 0;
    int newY = 0;

    for(int i=0; i<8; i++) {

      newX = x+eightWays[i][0];
      newY = y+eightWays[i][1];
      int[] newXy = {newX,newY};

      if( newX < 0 || newX > 4 || newY < 0 || newY > 4) continue;
      if(boggle[newX][newY] == keyword.charAt(pos)) {

        cache.put(x+","+y+","+keyword.charAt(pos), newXy);

        if(keyword.length() == pos+1) return true;

        while(true) {
          if(pos+1 == keyword.length()) return true;
          int[] cacheXY = cache.get(newX + "," + newY + "," + keyword.charAt(pos+1));
          if(cacheXY != null) {
            newX = cacheXY[0];
            newY = cacheXY[1];
            pos++;
          } else {
            break;
          }
        }

        if(find(newX,newY,keyword,pos+1)) return true;

      }
    }
    return false;
  }
}