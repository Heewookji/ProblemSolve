package picnic;

import java.util.Scanner;

public class Main {

  static int stuN;
  static int[][] couples;


  public static void main(String[] args) {

    Scanner sc  = new Scanner(System.in);

    int caseN = sc.nextInt();

    for(int n=0; n<caseN; n++) {

      stuN = sc.nextInt();
      int coupleN = sc.nextInt();
      couples = new int[coupleN][2];

      for(int cn=0; cn<coupleN; cn++) {
        couples[cn][0] = sc.nextInt();
        couples[cn][1] = sc.nextInt();
      }
      
      int sum = 0;
      for(int i=0; i<couples.length; i++) {
        sum += find(i, new boolean[10], 0);
      }
      System.out.println(sum);
    }
    sc.close();
  }

  private static int find(int index, boolean[] used, int count) {

    if(used[couples[index][0]] || used[couples[index][1]]) return 0;
    count = count + 2;
    if(count == stuN) return 1;

    int sum = 0;
    for(int i=0; i<couples.length; i++) {
      used[couples[index][0]] = true;
      used[couples[index][1]] = true;
      sum += find(i, used, count);
      used[couples[index][0]] = false;
      used[couples[index][1]] = false;
    }
    return sum;
  }


}
