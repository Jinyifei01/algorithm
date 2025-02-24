package leetcode;

import java.util.HashSet;
import java.util.Set;

public class problem2_17 {


    //使用哈希表存储
    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Set<ListNode> setA = new HashSet<ListNode>();
            ListNode tempA = headA;
            while (tempA != null) {
                setA.add(tempA);
                tempA = tempA.next;
            }
            ListNode tempB = headB;
            while (tempB != null) {
                if (setA.contains(tempB)) {
                    return tempB;
                }
                tempB = tempB.next;
            }
            return null;
        }
    }
//    相遇原理：
//    假设链表 A 的长度是 L1，链表 B 的长度是 L2，交点位置距离链表 A 和链表 B 的头部分别是 d1 和 d2。我们希望找到交点位置。
//    如果我们让 pA 和 pB 分别从 headA 和 headB 出发，当 pA 遍历完链表 A 时，它会转到链表 B 的头部，继续遍历链表 B。pB 也在遍历链表 B 完后转到链表 A 的头部。
//    这样，pA 和 pB 的每次遍历都可以“补偿”彼此链表的不同长度。在经过 L1 + L2 的步骤后，两个指针必定会同时相遇在交点（如果有交点的话）。
//    //方法二 双指针
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
