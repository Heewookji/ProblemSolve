class Solution {
  int removeDuplicates(List<int> nums) {
    int temp = -1;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          temp = nums[nums.length - 1];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
    return nums.length;
  }
}

void main() {
  List<int> nums = [1, 1, 2, 2];
  Solution().removeDuplicates(nums);
  print(nums);
}
