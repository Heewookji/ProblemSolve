package fanmeeting;

import java.util.Scanner;

public class Main {

  static String mems;
  static String fans;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t<testN; t++) {
      mems = sc.nextLine();
      fans = sc.nextLine();

      int ret = solve();
      System.out.println(ret);
    }
    sc.close();
  }

  private static int solve() {
    int N = mems.length(), M = fans.length();
    int[] A = new int[N], B = new int[M];
    for(int i=0; i<N; i++) A[i] = (mems.charAt(i) == 'M'? 1:0);
    for(int i=0; i<M; i++) B[M-i-1] = (fans.charAt(i) == 'M'? 1:0);

    int[] C = karatsuba(A,B);
    int sum = 0;
    for(int i=N-1; i<M; i++) {
      if(C[i] == 0) ++sum;
    }
    return sum;
  }

  private static int[] karatsuba(int[] a, int[] b) {
    return null;
  }
}



