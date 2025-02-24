package leetcode;

import java.util.HashSet;
import java.util.Set;

public class problem2_19_2 {
    //使用哈希表来存储
    public ListNode hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        int a=0;
        while (head != null) {
            if (!seen.add(head)) {
                return head;
            }
            head = head.next;
            a++;
        }
        return null;
    }


    //方法二  从相遇点到入环点的距离加上n−1圈的环长，恰好等于从链表头部到入环点的距离。
    public ListNode hasCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
