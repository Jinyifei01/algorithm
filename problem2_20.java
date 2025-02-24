package leetcode;

public class problem2_20 {

    //一位位相加超出范围
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry1 = 0;
        int carry2 = 0;
        int k=1,j=1;
        while (l1 != null ) {
            carry1 += l1.val*k;
            k=k*10;
            l1 = l1.next;
        }
        while (l2 != null ) {
            carry2 += l2.val*j;
            j=j*10;
            l2 = l2.next;
        }
        int sum = carry1 + carry2;
        ListNode cur = new ListNode(0);
        ListNode dummy = cur;
        if(sum==0) return dummy;
        while (sum !=0) {
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        return dummy.next;
    }


    //方法二 诸位相加 我们同时遍历两个链表，逐位计算它们的和，并与当前位置的进位值相加。
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;


    }
}
