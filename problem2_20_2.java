package leetcode;

public class problem2_20_2 {





//    方法三 双指针    链表解题经典三板斧，哑巴节点，栈，快慢指针。
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = head;
//        ListNode dummy_n = new ListNode(0, head);
//        ListNode ans = dummy_n;
//        while (n > 0) {
//
//            dummy = dummy.next;
//            n--;
//        }
//        while (dummy != null) {
//            dummy = dummy.next;
//            dummy_n = dummy_n.next;
//        }
//        dummy_n.next = dummy_n.next.next;
//        return ans.next;
//    }
}
