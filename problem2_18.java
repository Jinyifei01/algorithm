package leetcode;

public class problem2_18 {
    //方法一 双指针
    public ListNode reverseList(ListNode head) {
        ListNode pre =null;
        ListNode curr =head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

        }
        return pre;

    }

    //方法二 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    //123 321


}
