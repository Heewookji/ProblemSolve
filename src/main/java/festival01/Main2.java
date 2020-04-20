package festival01;

import java.util.Scanner;

public class Main2 {


  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    int tCase = in.nextInt();

    for(int c=0; c<tCase; c++) {

      int days = in.nextInt();
      int least = in.nextInt();
      int[] costs = new int[days];

      for(int j=0; j<days; j++) {
        costs[j] = in.nextInt();
      }

      double finalCost = 100;

      for(int i=0; i<=days-least; i++) {
        int sum = 0;
        for(int pos=i;pos<days; pos++) {
          int count = pos-i+1;
          sum += costs[pos];
          if(count >= least && (double)sum/count < finalCost) {
            finalCost = (double)sum/count;
          }
        }
      }
      System.out.println(finalCost);
    }
    in.close();
  }
}


