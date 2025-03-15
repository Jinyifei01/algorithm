package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class problem2_21_3 {
    //排序 使用递归算法 找到中点 分别排序两边 在合并 使用空间复杂度O（logn）
    public ListNode sortList(ListNode head) {
        // 递归终止条件：链表为空或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 找到链表的中点
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next; // 右半部分的头节点
        mid.next = null; // 断开链表

        // 递归排序左半部分和右半部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并两个有序链表
        return mergeTwoLists(left, right);
    }

    // 找到链表的中点（快慢指针法）
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // fast 从 head.next 开始，确保 slow 指向中点或左中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // 虚拟头节点
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // 将剩余的链表接上
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    //方法二
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Calculate the length of the linked list
        ListNode h = head;
        int length = 0;
        while (h != null) {
            h = h.next;
            length++;
        }

        // Create a dummy node
        ListNode res = new ListNode(0);
        res.next = head;

        // Merge lists in different interval sizes
        for (int intv = 1; intv < length; intv *= 2) {
            ListNode prev = res, current = res.next;
            while (current != null) {
                // Get the two heads h1 and h2
                ListNode h1 = current;
                int i = intv;
                while (i > 0 && current != null) {
                    current = current.next;
                    i--;
                }
                if (i > 0) break; // No need to merge, h2 is null

                ListNode h2 = current;
                i = intv;
                while (i > 0 && current != null) {
                    current = current.next;
                    i--;
                }

                int c1 = intv, c2 = intv - i; // Length of h2 may be less than intv
                // Merge h1 and h2
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        prev.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        prev.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    prev = prev.next;
                }

                // Append the remaining part of h1 or h2
                prev.next = (c1 > 0) ? h1 : h2;
                while (c1 > 0 || c2 > 0) {
                    prev = prev.next;
                    c1--;
                    c2--;
                }
                prev.next = current;
            }
        }

        return res.next;
    }

}
