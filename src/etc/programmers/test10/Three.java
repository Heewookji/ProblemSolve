package etc.programmers.test10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Three {

  class Pair {

    private int num;
    private int cost;

    public Pair(int num, int cost) {
      this.num = num;
      this.cost = cost;
    }

    public int getCost() {
      return cost;
    }

    public int getNum() {
      return num;
    }
  }

  public int solution(int n, int[][] edges) {
    return recursive(3, 1, edges, new ArrayList<Integer>());
  }

  private int recursive(int count, int referer, final int[][] edges, ArrayList<Integer> used) {

    if (count == 0) {
      int one = bfs(edges, used.get(0), used.get(1));
      int two = bfs(edges, used.get(1), used.get(2));
      int three = bfs(edges, used.get(0), used.get(2));
      return (one + two + three)/3;
    }
    int ret = Integer.MIN_VALUE;
    for (int i = referer; i <= edges.length + 1; i++) {
      used.add(i);
      ret = Math.max(ret, recursive(count - 1, i + 1, edges, used));
      used.remove(used.size() - 1);
    }

    return ret;
  }

  private int bfs(final int[][] edges, int start, int end) {
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(start, 0));

    while (!q.isEmpty()) {
      int here = q.peek().getNum();
      int cost = q.peek().getCost();
      q.poll();
      if (here == end)
        return cost;
      for (int i = 0; i < edges.length; i++) {
        if (edges[i][0] == here)
          q.add(new Pair(edges[i][1], cost + 1));
        else if (edges[i][1] == here)
          q.add(new Pair(edges[i][0], cost + 1));
      }
    }
    return 0;
  }

}
