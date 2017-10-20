/*
    Example
    For linked list 1->2->3, the reversed linked list is 3->2->1

    Challenge
    Reverse it in-place and in one-pass
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
