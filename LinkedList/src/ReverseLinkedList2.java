public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        head = dummyNode;
        //find preMNode;
        for (int i = 0; i < m - 1; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        //head is pointing the preMNode
        ListNode preMNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode nPostNode = mNode.next;

        for (int i = m; i < n; i++) {
            ListNode temp = nPostNode.next;
            nPostNode.next = nNode;
            nNode = nPostNode;
            nPostNode = temp;
        }

        mNode.next = nPostNode;
        preMNode.next = nNode;

        return dummyNode.next;
    }

    public static void main (String[] args) {
        ReverseLinkedList2 obj = new ReverseLinkedList2();
        ListNode head = new ListNode(1);

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node2;
//        node2.next = node3;
//        node3.next =node4;
//        node4.next = node5;
//        node5.next = node6;

        ListNode newHead = obj.reverseBetween(head, 1,2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
