package ㅡ10wildcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

  static List<String> output;
  static int[][] cache;
  static String wildcard;
  static String name;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t<testN; t++) {
      wildcard = sc.nextLine();
      int nameN = sc.nextInt();
      sc.nextLine();
      output = new ArrayList<String>();

      for(int n=0; n<nameN; n++) {
        name = sc.nextLine();
        cache = new int[101][101];
        int flag = find(0,0);
        if(flag == 1) output.add(name);
      }
      output.sort(null);
      for(int i=0; i<output.size(); i++) {
        sb.append(output.get(i)+ "\n");
      }
    }
    System.out.print(sb);
    sc.close();
  }

  private static int find(int wN, int nN) {
    if(cache[wN][nN] != 0) return cache[wN][nN];

    while(wN < wildcard.length() && nN < name.length() && (
        wildcard.charAt(wN) == '?' || wildcard.charAt(wN) == name.charAt(nN))) {
     return cache[wN][nN] = find(wN+1, nN+1);
    }
    if(wN == wildcard.length() ) return cache[wN][nN] = (nN == name.length())? 1:-1;
    if(wildcard.charAt(wN) == '*') {
     if(find(wN+1, nN) == 1 || 
         (nN < name.length() && find(wN, nN+1) == 1)) {
       return cache[wN][nN] = 1;
     }
    }
    return cache[wN][nN] = -1;
  }
}
