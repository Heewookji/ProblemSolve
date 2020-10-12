package etc.programmers.devmatching;

public class Solution {

  public String solution(String p, int n) {

    int hour = 0, min = 0, sec = 0;
    String[] first = p.split(" ");
    String[] HMS = first[1].split(":");

    int mCount = 0, hCount = 0;
    sec = Integer.parseInt(HMS[2]) + n;
    if (sec >= 60) {
      mCount = sec / 60;
      sec = sec % 60;
    }
    min = Integer.parseInt(HMS[1]) + mCount;
    if (min >= 60) {
      hCount = min / 60;
      min = min % 60;
    }
    if (HMS[0].equals("12")) {
      if (first[0].equalsIgnoreCase("AM"))
        hour = -12;
    } else {
      if (first[0].equalsIgnoreCase("PM"))
        hour = 12;
    }
    hour += Integer.parseInt(HMS[0]) + hCount;
    if (hour >= 24)
      hour = hour % 24;

    String answer = String.format("%02d:%02d:%02d", hour, min, sec);
    return answer;
  }
}
