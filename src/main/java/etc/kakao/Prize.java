package ㅡetc.kakao;

import java.util.ArrayList;

public class Prize {

  public static void main(String[] args) {
    System.out.println(solution("100-200*300-500+20"));
  }

  static ArrayList<Integer> numbers = new ArrayList<Integer>();
  static ArrayList<Character> operator = new ArrayList<Character>();

  public static long solution(String expression) {
    long answer = 0;
    String temp = "";
    for(int i=0; i<expression.length(); i++) {
      if(Character.isDigit(expression.charAt(i))) {
        temp = temp + expression.charAt(i);
        if(i == expression.length()-1) numbers.add(Integer.parseInt(temp));
      }
      else {
        numbers.add(Integer.parseInt(temp));
        temp = "";
        operator.add(expression.charAt(i));
      }
    }
    answer = recursive(new ArrayList<>());

    return answer;
  }

  public static long recursive(ArrayList<Integer> used) {

    if(used.size() == operator.size()) return Math.abs(calc(used));
    long ret = 0;
    for(int i=0; i<operator.size(); i++) {
      if(used.indexOf(i) != -1) continue;
      used.add(i);
      ret = Math.max(ret, recursive(used));
      used.remove(used.indexOf(i));
    }
    return ret;
  }

  public static long calc(ArrayList<Integer> used) {
    
    long sum = numbers.get(used.get(0));
    boolean[] flags = new boolean[used.size()];
    
    long ret1 = 0;
    
    for(int i=0; i<used.size(); i++) {
      int index = used.get(i);
      switch(operator.get(index)) {
        case '+': 
          if(i == 0) ret1 = sum + numbers.get(i+1);
          break;
        case '-': 
          if(i == 0) ret1 = sum - numbers.get(i+1);
          break;
        case '*': 
          if( index > 1 && (flags[index-1] == true)) ret1 = sum * numbers.get(i+1);
          break;
      }
    }
    return sum;
  }


}



