public class FindBeginningOfLoop {
    public ListNode findLoopStart(ListNode head){


        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }

        //error-check
        if(fast == null || fast.next == null) return null;

        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
