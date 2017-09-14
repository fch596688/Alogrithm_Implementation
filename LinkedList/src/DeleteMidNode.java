/**
 * Created by fch59 on 9/14/2017.
 */
public class DeleteMidNode {
    //consider the deleted node could be the last node of linked list ( mark the node as the dummy)
    public void deleteNode(Node mid){
        if(mid.next == null || mid == null) return;
        Node next = mid.next;
        mid.data = next.data;
        mid.next = next.next;
    }
}
