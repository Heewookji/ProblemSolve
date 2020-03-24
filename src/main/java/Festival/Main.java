package Festival;

import java.util.Scanner;

public class Main {

  static int[] costs = null;
  static int least = 0;



  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    int caseCount = keyboard.nextInt();

    //줄바꿈 출력
    keyboard.nextLine();

    for(int i=0; i < caseCount; i++) {

      int days = keyboard.nextInt();
      least = keyboard.nextInt();
      costs = new int[days];

      for(int j=0; j < days; j++) {
        costs[j] = keyboard.nextInt();
      }

      double finalCost = 100;
      for(int f=0; f < days; f++) {
        double cost = 0;
        if( f <= days-least) {
          cost = find( f, 0, 1 );
          if (cost < finalCost) {
            finalCost = cost;
          }
        }
      }
      System.out.println(finalCost); 
    }
  }


  private static double find( int costNum, double allCost, int count ) {

    if(costNum == costs.length)
      return 100;

    allCost = costs[costNum] + allCost;

    double leastCost = allCost/count;

    costNum++;
    count++;

    double cost = find(costNum, allCost, count);

    if ( leastCost > cost || count-1 < least )
      leastCost = cost;

    return leastCost;
  }

}

