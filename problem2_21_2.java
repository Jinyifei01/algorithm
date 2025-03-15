package leetcode;

import java.util.HashMap;
import java.util.Map;

public class problem2_21_2 {

    //方法一 使用哈希表来存储新节点与老节点的对应关系
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 创建一个哈希表用于存储原节点和新节点之间的映射
        Map<Node, Node> nodeMap = new HashMap<>();
        // 第一次遍历：创建所有节点并存储在哈希表中
        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.val));
            current = current.next;
        }
        // 第二次遍历：设置新节点的 next 和 random 指针
        current = head;
        while (current != null) {
            nodeMap.get(current).next = nodeMap.get(current.next);
            nodeMap.get(current).random = nodeMap.get(current.random);
            current = current.next;
        }
        // 返回新的链表的头节点
        return nodeMap.get(head);
    }
    //方法二 递归方法

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);  // 创建一个新的节点
            cachedNode.put(head, headNew);      // 将原节点和新节点的关系存入缓存
            headNew.next = copyRandomList2(head.next); // 递归复制 next 指针
            headNew.random = copyRandomList2(head.random); // 递归复制 random 指针
        }
        return cachedNode.get(head); // 返回缓存中的复制节点
    }

    //方法三 在每一个节点后插入复制节点 节省hash表的存储空间
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        // 1. 遍历链表，在每一个节点后插入复制节点
        // 结果展示: 1->3->5->7  =>  1->1->3->3->5->5->7->7
        Node curr = head;
        while(curr != null){
            // 1.1 复制val
            Node copy = new Node(curr.val);
            // 1.2 将复制节点放入当前节点后面，copy的下一节点指向curr的下一节点，curr的下一节点指向copy
            copy.next = curr.next;
            curr.next = copy;
            // 1.3 更新当前节点
            curr = copy.next;
        }

        // 2. 遍历链表，将原节点的随机值交给复制节点
        curr = head;
        while(curr != null){
            // 2.1 获取原链表的复制节点
            Node copy = curr.next;
            // 2.2 获取原链表的random
            Node random = curr.random;
            // 2.3 复制节点的random未赋值，默认为空，只需要处理原节点random非空
            if(random != null){
                // 2.4 获取复制节点的random位置,因为插入了复制节点，链表长度翻了一倍，所以对应的复制节点的对应的random也在原链表random的后面一位
                Node copyRandom = random.next;
                copy.random = copyRandom;
            }
            // 2.5 移动到下一个原始节点
            curr = copy.next;
        }

        // 3. 遍历链表，分离原始节点和复制节点，分离需要同时更新所有节点的next指针，不然就有两个节点指向同一个next
        curr = head;
        // 3.1 获取新链表的头部
        Node newHead = curr.next;
        Node copyCurrent = newHead;
        while(curr != null){
            // 3.2 更新当前原节点的next指针,使其指向下一个原节点
            curr.next = copyCurrent.next;
            // 3.3 移动到下一个原节点，当前原节点已经变为下一个原节点
            curr = curr.next;
            if(curr != null){
                // 3.4.1 下一个原节点不为空 更新复制节点的next指针，指向下一个原节点的下一个节点
                copyCurrent.next = curr.next;
            }else{
                // 3.4.2 下一个原节点为空，下一个复制节点也为空
                copyCurrent.next = null;
            }
            // 3.5 更新复制节点
            copyCurrent = copyCurrent.next;
        }
        return newHead;
    }

}
