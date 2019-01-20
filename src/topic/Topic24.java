package topic;

/**
 * @author zhuyao
 * @date 2019/01/19
 */
public class Topic24 {
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preListNode = null;
        ListNode nowListNode = head;
        while (nowListNode != null) {
            //保存下一个结点
            ListNode nextListNode = nowListNode.next;
            //当前结点指向前一个结点
            nowListNode.next = preListNode;
            //前任结点 到现任节点
            preListNode = nowListNode;
            //现任节点到下一结点
            nowListNode = nextListNode;
        }
        return preListNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.next = second;
        second.next = third;
        third.next = forth;
        head.data = 1;
        second.data = 2;
        third.data = 3;
        forth.data = 4;
        Topic24 test = new Topic24();
        ListNode result = test.reverseList(head);
        System.out.println(result.data);
    }

    public static class ListNode {
        int data;
        ListNode next = null;
        ListNode() { }
    }
}
