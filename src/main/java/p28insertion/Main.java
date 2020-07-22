package p28insertion;

import java.util.Scanner;

public class Main {
  
  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for(int i = 0; i < testN; i++){
      int n = sc.nextInt();
      int[] resultArr = new int[n];
      int[] originArr = new int[n];
      for(int j = 0; j < n; j++)
       resultArr[j] = sc.nextInt();
      find(n, originArr, resultArr);
      for(int j = 0; j < n; j++)
        System.out.print(originArr[j] + " ");
      System.out.println();
    }
  }

  private static void find(int n, int[] originArr, final int[] resultArr){
    
    for(int i = n - 1; i >= 0; i--){
      int larger = resultArr[i];
      originArr[i] = n + 1 - larger;
    }
    Util.insert(new Node(3), new Node(1));

  }
}