public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        //copy list
        copyList(head);
        //copy random
        copyRandom(head);
        //split list
        return splitList(head);
    }

    private void copyList (RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }

    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private RandomListNode splitList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode node = dummy;
        while(head != null) {
            node.next = head.next;
            node = node.next;
            head = head.next.next;
        }
        return dummy.next;
    }
}
