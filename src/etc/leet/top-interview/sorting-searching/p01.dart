class Solution {
  void merge(List<int> nums1, int m, List<int> nums2, int n) {
    int num1Pointer = m - 1;
    int num2Pointer = n - 1;
    for (int i = nums1.length - 1; i >= 0; i--) {
      if (num2Pointer < 0) {
        nums1[i] = nums1[num1Pointer--];
      } else if (num1Pointer < 0) {
        nums1[i] = nums2[num2Pointer--];
      } else {
        nums1[i] = nums1[num1Pointer] >= nums2[num2Pointer]
            ? nums1[num1Pointer--]
            : nums2[num2Pointer--];
      }
    }
    print('$nums1');
  }
}

void main() {
  Solution().merge(
    [1, 2, 3, 0, 0, 0],
    3,
    [2, 5, 6],
    3,
  );
}
