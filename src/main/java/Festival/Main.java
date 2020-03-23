package Festival;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    int caseCount = keyboard.nextInt();

    //줄바꿈 출력
    keyboard.nextLine();
    
    for(int i=0; i < caseCount; i++) {

      int days = keyboard.nextInt();
      int least = keyboard.nextInt();
      int[] costs = new int[days];
      
      for(int j=0; j < days; j++) {
        costs[j] = keyboard.nextInt();
      }
      
      
      System.out.println(days + " " + least);
      
      for(int j=0; j < days; j++) {
        System.out.print(costs[j] + " ");
      }
    }

  }

}

