package p01festival;

import java.util.Scanner;

public class Main3 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();

    for(int t=0; t<testN; t++) {

      int dayN = sc.nextInt();
      int leastN = sc.nextInt();
      int[] days = new int[dayN];

      for(int d=0; d<dayN; d++) {
        days[d] = sc.nextInt();
      }
      
      double result = 100;
      for(int p=0; p<=dayN-leastN; p++) {
        int sum = 0;
        for(int i=p; i<dayN; i++) {
          sum += days[i];
          if(i-p+1<leastN) continue;
          else {
            double cost = (double)sum/(i-p+1);
            if(cost < result) result = cost;
          }
        }
      }
      System.out.println(result);
    }
  }

}


