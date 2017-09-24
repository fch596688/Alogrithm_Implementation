public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head){
        if (head == null) return true;

        final ListNode middleNode = findMiddle(head);
        middleNode.next = reverse(middleNode.next);

        return isEqual(head, middleNode.next);
    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        while(head != null){

            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
    private boolean isEqual(ListNode l1, ListNode l2){
        while(l1 != null && l2 != null){
            if(l1.val != l2.val){
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2 == null;
    }

    public static void main (String[] args){
        PalindromeLinkedList list = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode (2);
        head.next.next.next = new ListNode(1);
        boolean palindrome = list.isPalindrome(head);
        System.out.println(palindrome);
    }
}
