public class Intersection {
    public class Result{
        ListNode tail;
        int size;
        public Result(ListNode tail, int size){
            this.tail = tail;
            this.size = size;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        Result result1 = getTailAndSize(headA);
        Result result2 = getTailAndSize(headB);

        if (result1.tail != result2.tail) return null;
        ListNode shorter = result1.size > result2.size? headB : headA;
        ListNode longer = result1.size > result2.size? headA: headB;

        longer = getKthNode(longer, Math.abs(result1.size - result2.size ));
        while(shorter != longer){
            shorter = shorter.next;
            longer  = longer.next;
        }
        return longer;
    }

    private Result getTailAndSize(ListNode head) {
        if(head == null) return null;
        int size = 1;
        ListNode current = head;
        while(current.next != null){
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    private ListNode getKthNode(ListNode head, int k){
        ListNode current = head;
        for( int i = 0; i < k; i++){
            current = current.next;
        }
        return current;
    }

    public static void main (String[] args){
        Intersection list = new Intersection();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode (3);
//        head.next.next.next = new ListNode(4);
//        ListNode head1 = head.next.next;
        ListNode head = null;
        ListNode head1 = null;
        ListNode palindrome = list.getIntersectionNode(head, head1);
        System.out.println(palindrome);
    }
}
