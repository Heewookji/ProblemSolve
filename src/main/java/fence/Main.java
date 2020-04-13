package fence;

import java.util.Scanner;

public class Main {

  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
      int woodN = sc.nextInt();
      int[] woods = new int[woodN];
      
      for(int w=0; w<woodN; w++){
        woods[w] = sc.nextInt();
      }
      
      int ret = 0;
      for(int i=0; i<woodN; i++) {
        int least = 10000;
        for(int j=i; j<woodN; j++) {
          if(least > woods[j]) least = woods[j];
          if( least * (j-i+1) > ret ) ret = least * (j-i+1);
        }
      }
      System.out.println(ret);
    }
    sc.close();
  }
  
  
}
