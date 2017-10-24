/**
 * Created by fch59 on 10/20/2017.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
        }

        if (right != null) {
            tail.next = right;
        }

        return dummy.next;
    }
}
