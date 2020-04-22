package pi14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static String line;
  static int[] cache;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int testN = Integer.parseInt(br.readLine());

    for(int t=0; t<testN; t++) {
      line = br.readLine();
      cache = new int[line.length()+1];
      int count = find(0);
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }

  private static int classify(int begin, int end) {
    
    String target = line.substring(begin, end+1);
    char first = target.charAt(0);
    
    boolean flag = true;
    for(int i=0; i<target.length(); i++) {
      if(target.charAt(i) != first) flag = false;
    }
    if(flag) return 1;
    
    boolean progressive = true;
    
    for(int i=0; i<target.length()-1; i++) {
      if(target.charAt(i+1) - target.charAt(i) != target.charAt(1) - target.charAt(0)) {
        progressive = false;
      }
    }
    if(progressive && Math.abs(target.charAt(1) - target.charAt(0)) == 1) return 2;
    
    boolean alternating = true;
    for(int i=0; i<target.length(); i++) {
      if(target.charAt(i) != target.charAt(i%2))
        alternating = false;
    }
    if(alternating) return 4;
    if(progressive) return 5;
    return 10;
  }

  private static int find(int begin) {
    
    if(cache[begin] != 0) return cache[begin];

    if(begin == line.length()) return 0;
    int ret = 999999999;
    for(int l=3; l<=5; l++) {
      if(begin+l <= line.length())
        ret = Math.min(ret, find(begin+l) + classify(begin, begin+l-1));
    }
    return cache[begin] = ret;
  }
}


