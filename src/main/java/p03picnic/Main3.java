package ㅡ03picnic;

import java.util.Scanner;

public class Main3 {
  
  static int n;
  static boolean[] result;
  static boolean[][] couple;

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int testN = sc.nextInt();
    
    for(int t=0; t<testN; t++) {
      
      n = sc.nextInt();
      result = new boolean[n];
      int coupleN = sc.nextInt();
      couple = new boolean[n][n];
      
      for(int i=0; i<coupleN; i++) {
        couple[sc.nextInt()][sc.nextInt()] = true; 
      }
      
      System.out.println(find());
    }
  }
  
  private static int find() {
    
    int solo = -1;
    for(int i=0; i<n; i++) {
      if(result[i] == false) {
        solo = i;
        break;
      }
    }
    if(solo == -1) return 1;
    
    int sum = 0;
    for(int solo2=solo+1; solo2<n; solo2++) {
      if(!(couple[solo][solo2] || couple[solo2][solo])) continue;
      if(result[solo2]) continue;
      result[solo] = true;
      result[solo2] = true;
      sum += find();
      result[solo] = false;
      result[solo2] = false;
    }
    return sum;
  }
  
}
