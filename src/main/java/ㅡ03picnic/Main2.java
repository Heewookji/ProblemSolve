package ㅡ03picnic;

import java.util.Scanner;

public class Main2 {

  static boolean[] used;
  static boolean[][] couples;
  static int studN;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);    

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      studN = sc.nextInt();
      int coupN = sc.nextInt();
      used = new boolean[studN];
      couples = new boolean[studN][studN];

      for(int c=0; c<coupN; c++) {
        int first = sc.nextInt();
        int second = sc.nextInt();
        couples[first][second] = true;
        couples[second][first] = true;
      }

      int result = find();
      System.out.println(result);
    }
    sc.close();
  }

  private static int find() {

    int pos = -1;
    for(int i=0; i<studN; i++) {
      if(!used[i]) {
        pos = i; 
        break;
      }
    }
    if(pos == -1) return 1;
    
    int sum = 0;
    for(int pair=pos+1; pair<studN; pair++) {
      if( !used[pair] && couples[pos][pair]) {
        used[pos] = used[pair] = true;
        sum += find();
        used[pos] = used[pair] = false;
      }
    }
    return sum;
  }

}
