package p33meetingroom;

import java.util.Scanner;

class Meeting {

  private int start;
  private int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

}

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int testN = sc.nextInt();

    for (int i = 0; i < testN; i++) {
      int n = sc.nextInt();
      Meeting[] meetings = new Meeting[2 * n];
      for (int j = 0; j < meetings.length; j++)
        meetings[j] = new Meeting(sc.nextInt(), sc.nextInt());
      int[][] adj = makeGraph(meetings);
    }


    sc.close();
  }

  private static int[][] makeGraph(final Meeting[] meetings) {

    int meetingN = meetings.length;
    int[][] adj = new int[meetingN * 2][meetingN * 2];

    for (int i = 0; i < meetingN; i += 2) {
      int j = i + 1;
      adj[i * 2 + 1][j * 2]++;
      adj[j * 2 + 1][i * 2]++;
    }
    for (int i = 0; i < meetingN; i++) {
      for (int j = i + 1; j < meetingN; j++) {
        if (!duplicate(meetings[i], meetings[j])) {
          adj[i * 2][j * 2 + 1]++;
          adj[j * 2][i * 2 + 1]++;
        }
      }
    }
    return adj;
  }

  private static boolean duplicate(Meeting a, Meeting b) {
    return a.getEnd() <= b.getStart() || b.getEnd() <= a.getStart();
  }

}