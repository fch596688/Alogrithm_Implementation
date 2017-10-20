public class ReorderLinkedList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode middle = findMiddle(head);
        ListNode middleNext = reverse(middle.next);
        //this is key point!
        middle.next = null;
        merge(head, middleNext);
    }
    //123-456
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //123-654
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    //162534
    private void merge (ListNode head, ListNode reversedHead) {
        ListNode left = head;
        ListNode right = reversedHead;
        ListNode dummy = new ListNode(-1);

        int index = 0;
        while (left != null && right != null) {
            if(index % 2 == 0) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
            index++;
        }

        if (left != null) {
            dummy.next = left;
        } else {
            dummy.next = right;
        }
    }
}
