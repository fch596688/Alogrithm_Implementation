public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                head.next =  l2;
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }

            if (l1 == null) {
                head.next = l2;
            }

            if (l2 == null) {
                head.next = l1;
            }
        }

        return dummyNode.next;
    }
}
