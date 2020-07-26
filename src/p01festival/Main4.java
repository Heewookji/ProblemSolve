package p01festival;

import java.util.Scanner;

public class Main4 {
  
  static int[] days;
  static int least;

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
     int day = sc.nextInt();
     least = sc.nextInt();
     days = new int[day];
     
     for(int i=0; i<day; i++) {
       days[i] = sc.nextInt();
     }
     System.out.printf("%.11f%n",find());
    }
  }
  
  private static double find() {
    
    double ret = 1000;
    for(int pos=0; pos+least<=days.length; pos++) {
      int sum = 0;
      for(int len=pos; len<days.length; len++) {
        sum += days[len];
        if(len-pos+1>=least && (ret >((double)sum/(len-pos+1)))) {
          ret = (double)sum/(len-pos+1);
        }
      }
    }
    return ret;
  }
  
}
