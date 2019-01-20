package topic;

/**
 * @author zhuyao
 * @date 2019/01/14
 */
public class Topic18 {


    static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.value = value;
            this.next = next;
        }

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }
    }

    /**
     * 平均时间复杂度为O(1)，删除链表节点
     *
     * @param head            头结点
     * @param nodeToBeDeleted 待删除节点
     */
    public static void deleteNode(Node head, Node nodeToBeDeleted) {
        if (head == null || nodeToBeDeleted == null) {
            return;
        }

        //要删除的节点不是尾节点 O(1)
        if (nodeToBeDeleted.next != null) {
            nodeToBeDeleted.value = nodeToBeDeleted.next.value;
            nodeToBeDeleted.next = nodeToBeDeleted.next.next;
        } else if (head == nodeToBeDeleted) {
            // 要删除头节点，而且链表只有一个节点 O(1)
            nodeToBeDeleted = null;
            head = null;
        } else {
            Node tmp = head;
            //要删除尾节点，而且链表有多个节点 O(n)
            while (tmp.next != nodeToBeDeleted) {
                tmp = tmp.next;
            }
            tmp.next = null;
            nodeToBeDeleted = null;
        }
    }

    //有序链表中删除重复结点
    public Node deleteDuplication(Node pHead) {
        if (pHead == null || pHead.next == null) {
            // 只有0个或1个结点，则返回
            return pHead;
        }
        if (pHead.value == pHead.next.value) {
            // 当前结点是重复结点
            Node pNode = pHead.next;
            while (pNode != null && pNode.value == pHead.value) {
                // 跳过值与当前结点相同的全部结点,找到第一个与当前结点不同的结点
                pNode = pNode.next;
            }
            // 从第一个与当前结点不同的结点开始递归
            return deleteDuplication(pNode);
        } else {
            // 当前结点不是重复结点
            // 保留当前结点，从下一个结点开始递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        Node<Integer> node5 = new Node<>(5, null);
        Node<Integer> node4 = new Node<>(4, node5);
        Node<Integer> node3 = new Node<>(3, node4);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> headNode = new Node<>(1, node2);
        Node<Integer> deleteNode = new Node<>(3, node4);
        while (headNode.next != null) {
            System.out.println(headNode.next.value);
            headNode.next = headNode.next.next;
        }
        deleteNode(headNode, deleteNode);
        while (headNode.next != null) {
            System.out.println(headNode.next.value);
            headNode.next = headNode.next.next;
        }


    }

}
