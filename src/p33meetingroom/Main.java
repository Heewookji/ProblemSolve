package p33meetingroom;

import java.util.ArrayList;
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

class Pair {

  private int order;
  private int number;

  public Pair(int order, int number) {
    this.order = order;
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public int getOrder() {
    return order;
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
      int[] ans = solve2SAT(adj);
      if (ans.length == 0) {
        System.out.println("IMPOSSIBLE");
        continue;
      }
      StringBuilder line = new StringBuilder("POSSIBLE\n");
      for (int j = 0; j < ans.length; j++)
        if (ans[j] == 1)
          line.append(meetings[j].getStart() + " " + meetings[j].getEnd() + "\n");
      System.out.println(line);
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

  private static int[] solve2SAT(int[][] adj) {

    int n = adj.length / 2;
    int[] label = SCCUtil.tarjanSCC(adj);

    for (int i = 0; i < 2 * n; i += 2)
      if (label[i] == label[i + 1])
        return new int[0];

    int[] ans = new int[n];
    ArrayList<Pair> order = new ArrayList<>();
    for (int i = 0; i < 2 * n; i++)
      order.add(new Pair(label[i], i));
    order.sort((Pair p1, Pair p2) -> {
      return p2.getOrder() - p1.getOrder();
    });
    for (int i = 0; i < 2 * n; i++) {
      int vertex = order.get(i).getNumber();
      int variable = vertex / 2;
      if (ans[variable] != 0)
        continue;
      // A가 !A보다 먼저 나올 경우 A는 FALSE(-1)
      ans[variable] = vertex % 2 == 0 ? -1 : 1;
    }
    return ans;
  }

}
