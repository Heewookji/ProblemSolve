package kakao.spring2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class CourseMenu {

  public static void main(String[] args) {
    new CourseMenu().solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 });
  }

  static String[] al;

  public String[] solution(String[] orders, int[] course) {

    Arrays.sort(orders);
    ArrayList<String> list = new ArrayList<>();

    HashSet<String> set = new HashSet<>();

    for (String order : orders)
      for (char c : order.toCharArray())
        set.add(String.valueOf(c));

    al = set.toArray(new String[set.size()]);

    for (int i = 0; i < course.length; i++) {
      HashMap<String, Integer> map = new HashMap<>();
      int count = find(course[i], orders, "", -1, map);
      for (Map.Entry<String, Integer> e : map.entrySet())
        if (e.getValue() == count)
          list.add(e.getKey());
    }
    String[] ret = new String[list.size()];
    Collections.sort(list);

    return list.toArray(ret);
  }

  private int find(int n, final String[] orders, String menu, int referer, HashMap<String, Integer> map) {
    if (n == 0)
      return calculate(orders, menu, map);
    int count = 0;
    for (int i = referer + 1; i < al.length; i++)
      count = Math.max(count, find(n - 1, orders, menu + al[i], i, map));
    return count;
  }

  private int calculate(final String[] orders, String menu, HashMap<String, Integer> map) {
    int count = 0;
    for (String order : orders) {
      if (order.length() < menu.length())
        continue;
      int cCount = 0;
      for (char c : menu.toCharArray())
        if (order.indexOf(c) != -1)
          cCount++;
      if (cCount == menu.length())
        count++;
    }
    if (count >= 2)
      map.put(menu, count);
    return count;
  }
}
