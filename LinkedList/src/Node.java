/**
 * Created by fch59 on 9/13/2017.
 */
public class Node {
    Node next;
    int data;
    int val;
    public Node(int data){
        this.data = data;
        this.val = data;
        this.next = null;
    }

    public int length(){
        int length = 0;
        Node n = this;
        if(n == null) return 0;
        while(n != null){
            length++;
            n = n.next;
        }
        return length;
    }
}
