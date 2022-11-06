package etc.programmers.school.p03;

import java.util.HashSet;
import java.util.Objects;

public class Main {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int result = solution.solution("ULURRDLLU");
    System.out.println(result);
  }
}

class Path {

  private final Point start;
  private final Point end;

  Path(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean equals(Object obj) {
    if (getClass() != obj.getClass()) {
      return false;
    }
    Path another = (Path) obj;
    return (another.start.equals(start) && another.end.equals(end))
        || (another.start.equals(end) && another.end.equals(start));
  }

  @Override
  public int hashCode() {
    return start.hashCode() + end.hashCode();
  }

}

class Point {

  private final int x;
  private final int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  static Point getNextPoint(Point now, char dir) {
    int x = now.x;
    int y = now.y;
    switch (dir) {
      case 'U':
        y++;
        break;
      case 'D':
        y--;
        break;
      case 'L':
        x--;
        break;
      case 'R':
        x++;
        break;
    }
    return new Point(x, y);
  }

  boolean isInvalid() {
    return x < -5 || x > 5 || y < -5 || y > 5;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public boolean equals(Object obj) {
    if (getClass() != obj.getClass()) {
      return false;
    }
    Point another = (Point) obj;
    return another.x == x && another.y == y;
  }
}

class Solution {

  public int solution(String dirs) {
    Point now = new Point(0, 0);
    HashSet<Path> paths = new HashSet<>();
    for (char dir : dirs.toCharArray()) {
      Point next = Point.getNextPoint(now, dir);
      if (next.isInvalid()) {
        continue;
      }
      paths.add(new Path(now, next));
      now = next;
    }
    return paths.size();
  }
}
