package p15quantize;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int[] numbs;
  static int[] pSum;
  static int[] pSqSum;
  static int[][] cache;
  static int numbN;
  static int INF = 987654321;


  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int testN = Integer.parseInt(br.readLine());

    for(int t=0; t<testN; t++) {

      String line = br.readLine();
      StringTokenizer st = new StringTokenizer(line);
      numbN = Integer.parseInt(st.nextToken());
      int useN = Integer.parseInt(st.nextToken());
      numbs = new int[numbN];
      pSum = new int[numbN];
      pSqSum = new int[numbN];
      cache = new int[numbN][useN+1];

      line = br.readLine();
      st = new StringTokenizer(line);
      for(int n=0; n<numbN; n++) {
        numbs[n] = Integer.parseInt(st.nextToken());
      }
      precalc();
      sb.append(find(0, useN)).append("\n");
    }
    System.out.println(sb);
  }
  
  private static void precalc() {
    Arrays.sort(numbs);
    pSum[0] = numbs[0];
    pSqSum[0] = numbs[0] * numbs[0];
    for(int i=1; i<numbN; i++) {
      pSum[i] = pSum[i-1] + numbs[i];
      pSqSum[i] = pSqSum[i-1] + numbs[i] * numbs[i];
    }
    for(int i=0; i<numbN; i++) {
      Arrays.fill(cache[i], -1);
    }
  }

  private static int minError(int lo, int hi) {
    int sum = pSum[hi] - (lo == 0 ? 0 : pSum[lo-1]);
    int sqSum = pSqSum[hi] - (lo == 0? 0: pSqSum[lo-1]);
    int m = (int)(0.5 + (double)sum/ (hi - lo + 1));
    int ret = sqSum - 2 * m * sum + m * m * (hi - lo + 1);
    return ret;
  }

  private static int find(int from, int parts) {

    if(from == numbs.length) return 0;
    if(parts == 0) return INF;
    if(cache[from][parts] != -1) return cache[from][parts];

    int ret = INF;

    for(int partSize=1; from+partSize<= numbs.length; partSize++) {
      ret = Math.min(ret, find(from+partSize, parts-1) + minError(from, from + partSize-1));
    }
    return cache[from][parts] = ret;
  }

}
