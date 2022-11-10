class ListNode {
  int val;
  ListNode? next;

  ListNode([this.val = 0, this.next]);

  @override
  String toString() {
    return this.val.toString();
  }
}

class Solution {
  ListNode? removeNthFromEnd(ListNode? head, int n) {
    int length = 0;
    ListNode? current = head;
    while (current != null) {
      length++;
      current = current.next;
    }
    if (length == n) return head!.next;
    current = head;
    int beforeRemoveIndex = length - n - 1;
    for (int i = 0; i < beforeRemoveIndex; i++) {
      current = current!.next;
    }
    current?.next = current.next?.next;
    return head;
  }
}

class Solution2 {
  ListNode? removeNthFromEnd(ListNode? head, int n) {
    int length = 0;
    ListNode? current = head;
    ListNode? beforeRemove = head;
    while (current != null) {
      length++;
      if (length > n + 1) {
        beforeRemove = beforeRemove!.next;
      }
      current = current.next;
    }
    // if (length == n) return head!.next;
    beforeRemove?.next = beforeRemove.next?.next;
    return head;
  }
}

void main() {
  ListNode? answer = Solution().removeNthFromEnd(
      ListNode(
        1,
        ListNode(
          2,
          ListNode(
            3,
            ListNode(
              4,
              ListNode(5),
            ),
          ),
        ),
      ),
      2);
  while (answer != null) {
    print(answer);
    answer = answer.next;
  }
}
