package topic;

/**
 * @author zhuyao
 * @date 2019/01/14
 */
public class Topic18 {


    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.value = value;
            this.next = next;
        }
    }

    public static void DeleteNode(Node<Integer> headNode, Node<Integer> deleteNode) {
        if (headNode == null || deleteNode == null) {
            return;
        }

        if (deleteNode.next != null) {
            // 链表有多个节点，要删除的不是尾节点:O(1)时间
            Node<Integer> tempNode = deleteNode.next;
            deleteNode.value = tempNode.value;
            deleteNode.next = tempNode.next;

            tempNode = null;
        } else if (headNode == deleteNode) {
            // 链表只有一个结点，删除头结点（也是尾结点）:O(1)时间
            deleteNode = null;
            headNode = null;
        } else {
            // 链表有多个节点，要删除的是尾节点:O(n)时间
            Node<Integer> tempNode = headNode;
            while (tempNode.next != deleteNode) {
                tempNode = tempNode.next;
            }

            tempNode.next = null;
            deleteNode = null;
        }
    }

}
