class Solution {
  int climbStairs(int n) {
    return recursive(n, List.filled(n + 1, 0));
  }

  int recursive(int n, List<int> cache) {
    if (n <= 2) return n;
    if (cache[n] != 0) return cache[n];
    return cache[n] = recursive(n - 1, cache) + recursive(n - 2, cache);
  }
}

void main() {
  print(Solution().climbStairs(3));
}
