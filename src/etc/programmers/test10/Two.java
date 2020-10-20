package etc.programmers.test10;

public class Two {
  int[] ret = new int[2];

  public int[] solution(int[][] arr) {
    int n = arr.length;
    recursive(arr, 0, 0, n);
    return ret;
  }
  private int isAllSame(final int[][] arr, int startX, int startY, int n) {
    for (int y = startY; y < startY + n; y++)
      for (int x = startX; x < startX + n; x++)
        if (arr[startY][startX] != arr[y][x])
          return -1;
    return arr[startY][startX];
  }
  private void recursive(int[][] arr, int startX, int startY, int n) {
    int check = isAllSame(arr, startX, startY, n);
    if (check != -1) {
      ret[check]++;
      return;
    }
    n /= 2;
    for (int i = 0; i < 2; i++)
      for (int j = 0; j < 2; j++)
        recursive(arr, startX + (i * n), startY + (j * n), n);
  }
}