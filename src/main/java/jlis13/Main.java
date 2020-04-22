package jlis13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  
  static int[] A;
  static int[] B;
  static int n;
  static int m;
  static int[][] cache = new int[101][101];
  static final long MIN = Long.MIN_VALUE;
  
  public static void main(String[] args) throws IOException {
    
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int testN = Integer.parseInt(br.readLine());
    for(int t=0; t<testN; t++) {
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      A = new int[n];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<n; i++) {
        A[i] = Integer.parseInt(st.nextToken());
      }
      B = new int[m];
      st = new StringTokenizer(br.readLine());
      for(int i=0; i<m; i++) {
        B[i] = Integer.parseInt(st.nextToken());
      }
      for(int i=0; i<101; i++) {
        Arrays.fill(cache[i], -1);
      }
      sb.append(find(-1,-1) - 2).append("\n");
    }
    System.out.print(sb.toString());
  }
  
  private static int find(int indexA, int indexB) {
    
    int ret = cache[indexA+1][indexB+1];
    if (ret != -1)
        return ret;
    
    ret = 2;
    long a = (indexA == -1? MIN : A[indexA]);
    long b = (indexB == -1? MIN : B[indexB]);
    long maxElement = Math.max(a, b);
    for(int nextA=indexA+1; nextA<n; nextA++) {
      if(maxElement < A[nextA]) ret = Math.max(ret, find(nextA, indexB) + 1);
    }
    for(int nextB=indexB+1; nextB<m; nextB++) {
      if(maxElement < B[nextB]) ret = Math.max(ret, find(indexA, nextB) + 1);
    }
    return cache[indexA+1][indexB+1] = ret;
  }
}
