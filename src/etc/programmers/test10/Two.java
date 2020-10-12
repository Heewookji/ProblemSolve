package etc.programmers.test10;

public class Two {

  public int[] solution(int[][] arr) {
    int n = arr.length;
    return recursive(arr, 0, 0, n, n);
  }

  private int[] recursive(int[][] arr, int startX, int startY, int endX, int endY) {
    int[] ret = new int[2];
    if (endX - startX == 1) {
      ret[arr[startY][startX]] = 1;
      return ret;
    }
    boolean flag0 = false;
    boolean flag1 = false;
    for (int y = startY; y < endY; y++) {
      for (int x = startX; x < endX; x++) {
        if (arr[y][x] == 0)
          flag0 = true;
        else
          flag1 = true;
      }
    }
    if (!(flag1 && flag0)) {
      if (flag0)
        ret[0] = 1;
      if (flag1)
        ret[1] = 1;
      return ret;
    }
    ;
    int half = (endY - startY) / 2;
    int[] another = recursive(arr, startX, startY, startX + half, startY + half);
    ret[0] += another[0];
    ret[1] += another[1];
    another = recursive(arr, startX, startY + half, startX + half, endY);
    ret[0] += another[0];
    ret[1] += another[1];
    another = recursive(arr, startX + half, startY, endX, startY + half);
    ret[0] += another[0];
    ret[1] += another[1];
    another = recursive(arr, startX + half, startY + half, endX, endY);
    ret[0] += another[0];
    ret[1] += another[1];

    return ret;
  }
}