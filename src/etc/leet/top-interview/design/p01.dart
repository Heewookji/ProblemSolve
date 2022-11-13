import 'dart:math';

class Solution {
  final List<int> nums;
  late final List<int> array;
  final random = Random();

  Solution(this.nums) {
    this.array = List.filled(nums.length, -1);
  }

  List<int> shuffle() {
    List<int> list = List.from(nums);
    for (int i = 0; i < nums.length; i++) {
      int removeIndex = random.nextInt(list.length);
      array[i] = list[removeIndex];
      list.removeAt(removeIndex);
    }
    return array;
  }

  List<int> reset() {
    return this.nums;
  }
}

class Solution2 {
  final List<int> nums;
  final random = Random();

  Solution2(this.nums);

  List<int> shuffle() {
    List<int> list = List.from(nums);
    int temp = 0;
    for (int i = 0; i < nums.length; i++) {
      int randomIndex = random.nextInt(list.length);
      temp = list[i];
      list[i] = list[randomIndex];
      list[randomIndex] = temp;
    }
    return list;
  }

  List<int> reset() {
    return this.nums;
  }
}

main() {
  Solution([1, 2, 3]).shuffle();
}
