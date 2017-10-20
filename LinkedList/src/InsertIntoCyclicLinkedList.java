public class InsertIntoCyclicLinkedList {
    public ListNode insert(ListNode node, int x) {
        if (node == null) {
            node = new ListNode(x);
            node.next = node;
            return node;
        }

        ListNode newNode = new ListNode(x);
        ListNode p = node;
        ListNode prev = p;
        p = p.next;
        while (p != node) {

            if (p.val >= newNode.val &&  prev.val <= newNode.val) {
                break;
            }
            if ((prev.val > p.val) && (newNode.val < p.val || newNode.val > prev.val)) {
                break;
            }
        }

        newNode.next = p;
        prev.next = newNode;
        return newNode;
    }
    private void printNode(ListNode node) {
        System.out.println(node.val);
        ListNode head = node;
        node = node.next;
        while (head != node) {
            System.out.println(node.val);
            node = node.next;
        }
    }
    public static void main(String[] args) {
        InsertIntoCyclicLinkedList obj = new InsertIntoCyclicLinkedList();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        ListNode newNode = obj.insert(node1, 4);
        obj.printNode(newNode);
    }
}
