package p33meetingroom;

import java.util.Arrays;
import java.util.Stack;

public class SCCUtil {

  private static int sccCounter, vertexCounter;
  private static int[] sccId, discovered;
  private static Stack<Integer> stack;

  public static int[] tarjanSCC(final int[][] adj) {

    sccId = discovered = new int[adj.length];
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
      if (discovered[there] == -1){
        ret = Math.min(ret, scc(adj, there));
      }
      else if (sccId[there] == -1){
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