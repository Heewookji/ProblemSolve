package p03picnic;

import java.util.Scanner;

public class Main {

  static int stuN;
  static boolean[][] couples;


  public static void main(String[] args) {

    Scanner sc  = new Scanner(System.in);

    int caseN = sc.nextInt();

    for(int n=0; n<caseN; n++) {

      stuN = sc.nextInt();
      int coupleN = sc.nextInt();
      couples = new boolean[stuN][stuN];

      for(int cn=0; cn<coupleN; cn++) {
        couples[sc.nextInt()][sc.nextInt()] = true;
      }

      int sum = find(new boolean[stuN]);
      System.out.println(sum);
    }
    sc.close();
  }

  private static int find(boolean[] students) {

    int first = -1;
    for(int i=0; i<students.length; i++) {
      if(!students[i]) {
        first = i;
        break;
      }
    }
    if(first == -1) return 1;

    int sum = 0;
    for(int pair=first+1; pair<stuN; pair++) {
      if(!students[pair] && (couples[first][pair]||couples[pair][first])) {
        students[first] = students[pair] = true;
        sum += find(students);
        students[first] = students[pair] = false;
      }
    }
    return sum;
  }

}
