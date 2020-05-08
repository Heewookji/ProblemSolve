package ㅡetc;

import java.util.ArrayList;
import java.util.Scanner;

public class Dart {

  static String line;

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int testN = sc.nextInt();
    sc.nextLine();

    for(int t=0; t<testN; t++) {
      line = sc.nextLine();

      System.out.println(find(line));
    }
  }

  private static int find(String line) {

    String temp = "";
    int score = 0;
    ArrayList<Integer> array = new ArrayList<Integer>();

    for(int i=0; i<line.length(); i++) {
      if(Character.isDigit(line.charAt(i))) temp = temp + line.charAt(i);
      else {
        int tempScore = Integer.parseInt(temp.length() != 0? temp : "-1");        
        switch(line.charAt(i)) {
          case 'S' : score = tempScore; break;
          case 'D' : score = (int) Math.pow(tempScore, 2); break;
          case 'T' : score = (int) Math.pow(tempScore, 3); break;
          case '*' : 
            array.set(array.size()-1, array.get(array.size()-1) * 2);
            if(array.size() > 1)array.set(array.size()-2, array.get(array.size()-2) * 2);
            break; 
          case '#' : 
            array.set(array.size()-1, array.get(array.size()-1) * -1);
            break;
        }
        if(tempScore != -1) array.add(score); 
        temp = "";
      }
    }
    int sum = 0;
    for(int i : array) {
      sum += i;
    }
    return sum;
  }
}

/**
1S2D*3T
1D2S#10S
1D2S0T  
1S*2T*3S
1D#2S*3S
1T2D3D# 
1D2S3T*
 **/