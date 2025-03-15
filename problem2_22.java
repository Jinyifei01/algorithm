package leetcode;

import java.util.PriorityQueue;

public class problem2_22 {
    //傻瓜方法
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode l : lists){
            if(l == null){continue;}
            cur.next = l;
            while (l.next != null){
                l = l.next;
            }
            cur = l;
        }
        ListNode ans =listnodeSort(dummy.next);
        return ans;
    }

    private ListNode listnodeSort(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head1 = head;
        ListNode head2 = slow.next;
        //断链
        slow.next = null;

        //slow为中点or中点左侧
        head1=listnodeSort(head1);
        head2=listnodeSort(head2);
        head=listnodeMerge(head1,head2);
        return head;
    }

    private ListNode listnodeMerge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                dummy.next = head1;
                head1 = head1.next;
            }
            else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        if(head1 != null){
            dummy.next = head1;
        }
        if(head2 != null){
            dummy.next = head2;
        }
        return ans.next;
    }




//    傻瓜方法二 两两合并
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = listnodeMerge2(ans, lists[i]);
    }
        return ans;
    }


    private ListNode listnodeMerge2(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                dummy.next = head1;
                head1 = head1.next;
            }
            else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
        }
        if(head1 != null){
            dummy.next = head1;
        }
        if(head2 != null){
            dummy.next = head2;
        }
        return ans.next;
    }

    //方法三  用分治的方法进行合并
    public ListNode mergeKLists3(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return listnodeMerge(merge(lists, l, mid), merge(lists, mid + 1, r));
    }





//    方法四  使用优先队列
    PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) ->o1.val-o2.val);
    public ListNode mergeKLists4(ListNode[] lists) {
        for(ListNode node:lists){
            if(node!=null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode s = pq.poll();
            cur.next = s;
            cur=cur.next;
            s = s.next;
            if(s!=null){
                pq.offer(s);
            }
        }
        return dummy.next;
    }
}
