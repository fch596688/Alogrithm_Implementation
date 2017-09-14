import java.util.LinkedList;

/**
 * Created by fch59 on 9/13/2017.
 */
public class ReturnKthToLast {


    public int printKthToLast(Node head, int k){
        if(head == null){
            return 0;
        }
        int index = printKthToLast(head.next, k) + 1;
        if(index == k){
            System.out.println(head.data);
        }
        return index;
    }

    public int printKthToLastIteration(Node head, int k){
        Node current = head;
        Node runner = head;
        for (int i = 0; i < k; i ++){
            if(runner == null) return 0;
            runner = runner.next;
        }

        while(runner != null){
            runner = runner.next;
            current = current.next;
        }
        return current.data;
    }

    public void display(Node head){
        Node n = head;
        while(n != null){
            System.out.print("->" + n.data);
            n = n.next;
        }
    }

    public static void main(String[] args){
        ReturnKthToLast test = new ReturnKthToLast();
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(8);
        n.next.next.next = new Node(3);
        n.next.next.next.next = new Node(7);
        n.next.next.next.next.next = new Node(0);
        n.next.next.next.next.next.next = new Node(4);
        test.display(n);
        System.out.print("\n Recursion::3rd Element from the end is : ");
        test.printKthToLast(n, 3);
        System.out.print("\n Iteration::5th Element from the end is : " + test.printKthToLastIteration(n, 5));
    }
}
