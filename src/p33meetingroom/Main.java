package p33meetingroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int caseN = sc.nextInt();

    for (int i = 0; i < caseN; i++) {
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
      System.out.println("POSSIBLE");
      for (int j = 0; j < ans.length; j++)
        if (ans[j] == 1)
          System.out.println(meetings[j].getStart() + " " + meetings[j].getEnd());
    }
    sc.close();
  }

  private static int[][] makeGraph(final Meeting[] meetings) {

    int meetingN = meetings.length;
    int[][] adj = new int[meetingN * 2][meetingN * 2];

    for (int i = 0; i < meetingN; i += 2) {
      int j = i + 1;
      adj[i * 2 + 1][j * 2]++; // !i -> j
      adj[j * 2 + 1][i * 2]++; // !j -> i
      adj[i * 2][j * 2 + 1]++; // i -> !j
      adj[j * 2][i * 2 + 1]++; // j -> !i
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

class SCCUtil {

  private static int sccCounter, vertexCounter;
  private static int[] sccId, discovered;
  private static Stack<Integer> stack;

  public static int[] tarjanSCC(final int[][] adj) {

    //책을 그대로 따라했다가, 값은 메모리를 가리키게 되어 혼쭐이 났다.
    sccId = new int[adj.length];
    discovered = new int[adj.length];
    stack = new Stack<>();
    Arrays.fill(sccId, -1);
    Arrays.fill(discovered, -1);
    sccCounter = vertexCounter = 0;
    for (int i = 0; i < adj.length; i++)
      if (discovered[i] == -1)
        scc(adj, i);
    return sccId;
  }

  private static int scc(final int[][] adj, int here) {
    int ret = discovered[here] = vertexCounter++;
    stack.push(here);
    for (int there = 0; there < adj[here].length; there++) {
      if (adj[here][there] == 0)
        continue;
      if (discovered[there] == -1) {
        ret = Math.min(ret, scc(adj, there));
      } else if (sccId[there] == -1) {
        ret = Math.min(ret, discovered[there]);
      }
    }
    if (ret == discovered[here]) {
      while (true) {
        int top = stack.peek();
        stack.pop();
        sccId[top] = sccCounter;
        if (top == here)
          break;
      }
      sccCounter++;
    }
    return ret;
  }
}

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