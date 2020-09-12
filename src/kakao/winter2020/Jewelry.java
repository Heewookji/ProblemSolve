package kakao.winter2020;

import java.util.ArrayList;

public class Jewelry {

  public static void main(String[] args) {

    String[] gems1 = {"","DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
    String[] gems2 = {"","AA", "AB", "AC", "AA", "AC"};
    String[] gems3 = {"","XYZ", "XYZ", "XYZ"};
    String[] gems4 = {"","ZZZ", "YYY", "NNNN", "YYY", "BBB"};
    int[] ret = solution(gems4);
    System.out.println(ret[0] + "," + ret[1]);
  }

  static int least;

  public static int[] solution(String[] gems) {
    int[] answer = {-1,-1};
    least = init(gems);
    System.out.println(least);

    int ans = gems.length;
    for(int pos=1; pos<gems.length; pos++) {
      for(int len=pos; len<gems.length; len++) {
        boolean flag = false;
        int ret = isCorrect(pos,len, gems, least);
        if(ans > ret) flag = true;
        else if(ans == ret && answer[0] > pos) flag = true;
        if(flag) {
          ans = ret;
          answer[0] = pos;
          answer[1] = len;
        }
      }
    }
    return answer;
  }
  public static int isCorrect(int start, int end, String[] gems, int least) {
    int ret = 9999;
    ArrayList<String> arrayList = new ArrayList<String>();
    for(int i=start; i<=end; i++) {
      if(!arrayList.contains(gems[i]))
        arrayList.add(gems[i]);
    }   
    if(arrayList.size() == least) ret = end - start;

    return ret;
  }
  public static int init(String[] gems) {
    ArrayList<String> arrayList = new ArrayList<String>();
    for(int i=1; i<gems.length; i++){
      if(!arrayList.contains(gems[i]))
        arrayList.add(gems[i]);
    }
    return arrayList.size();
  }

}
