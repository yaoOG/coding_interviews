package topic;

/**
 * @author zhuyao
 * @date 2019/01/19
 */
public class Topic23 {

    /**
     * 两个指针，一个指针步长为1，一个步长为2；
     * 先计算两个指针相交的位置点；
     * 然后让一个指针指向头结点，步长都为1，往后走，其相遇点就是入口点
     * 该规律可通过公式推导得出
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode targetNode;
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode preNode = pHead.next;
        ListNode postNode = pHead.next.next;
        // 找到相遇点
        while (preNode != postNode) {
            preNode = preNode.next;
            postNode = postNode.next.next;
        }
        // 将其中一个指针指向头结点
        postNode = pHead;
        // 步长都为1，同时往后走，直到两者相遇
        // 相遇点就是入口
        while (preNode != postNode) {
            preNode = preNode.next;
            postNode = postNode.next;
        }
        targetNode = preNode;

        return targetNode;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
