package ㅡetc.kakao;

import java.util.ArrayList;

public class Jewelry {

  public static void main(String[] args) {

    //String[] gems = {"","DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
    String[] gems = {"AA", "AB", "AC", "AA", "AC"};
    //String[] gems = {"XYZ", "XYZ", "XYZ"};
    //String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
    int[] ret = solution(gems);
    System.out.println(ret[0] + "," + ret[1]);
  }

  public static int[] solution(String[] gems) {
    int[] answer = {-1,-1};
    int least = init(gems);
    System.out.println(least);
    
    for(int pos=1; pos<gems.length; pos++) {
      for(int len=pos; len<gems.length; len++) {
        int ret = isCorrect(pos,len, gems, least);
        if(ret != -1 && least >= ret) {
          least = ret;
          answer[0] = pos;
          answer[1] = len;
        }
      }
    }
    return answer;
  }

  public static int init(String[] gems) {

    ArrayList<String> arrayList = new ArrayList<String>();
    for(int i=0; i<gems.length; i++){
      if(gems[i].length() != 0 && !arrayList.contains(gems[i]))
        arrayList.add(gems[i]);
    }
    return arrayList.size();
  }

  public static int isCorrect(int start, int end, String[] gems, int least) {

    int ret = -1;
    ArrayList<String> arrayList = new ArrayList<String>();
    for(int i=start; i<=end; i++) {
      if(gems[i].length() != 0 && !arrayList.contains(gems[i]))
        arrayList.add(gems[i]);
    }   
    if(arrayList.size() == least) {
      ret = end - start;
    }
    return ret;
  }

}
