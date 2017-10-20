/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

Example
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        //prev->n1 -> n2 .....nk->nk+1
        //prev->nk->nk-1->....n1->nk+1
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        //reverse API
        while (prev != null) {
            prev = reverseK(prev, k);
        }
        return dummyNode.next;
    }

    private ListNode reverseK(ListNode prev, int k) {
        ListNode nodeK = prev;

        for (int i = 0; i < k; i++) {
            if (nodeK == null) {
                return null;
            }
            nodeK = nodeK.next;
        }

        if (nodeK == null) {
            return null;
        }

        ListNode nodeKPlus = nodeK.next;
        ListNode node1 = prev.next;
        ListNode preNode1 = prev;
        ListNode curr = prev.next;

        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        preNode1.next = nodeK;
        node1.next = nodeKPlus;

        return node1;
    }
}
