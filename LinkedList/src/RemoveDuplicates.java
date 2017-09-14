import java.util.HashSet;

/**
 * Created by fch59 on 9/13/2017.
 */
public class RemoveDuplicates {
    public void deleteDups(LinkedListNode n){
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while(n != null){
            if(set.contains(n.data)){
                previous.next = n.next;
            }else{
                set.add(n.data);
                previous = n;
            }
        }
    }

    public void deleteDupsWithoutBuffer(LinkedListNode head){
        LinkedListNode current = head;
        while( current != null){
            //Remove all future nodes that have the same value
            LinkedListNode runner = current;
            while(runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
