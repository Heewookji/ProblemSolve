class Solution {
  int hammingDistance(int x, int y) {
    int result = x ^ y;
    int count = 0;
    while (result != 0) {
      if (result % 2 == 1) count++;
      result >>= 1;
    }
    return count;
  }
}

main() {
  print(Solution().hammingDistance(4, 1));
}
