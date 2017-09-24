public class PartitionLinkedList {
    public Node Partition(Node node, int x){
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        //partition the linked list
        //loop through linked list
        while(node != null){
            Node next = node.next;
            node.next = null;

            if(node.data < x){
                if(beforeStart == null){
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }else{
                    //append this node to before list
                    beforeEnd.next = node;
                    //beforeEnd points to the new node
                    beforeEnd = node;
                }
            }else{
                if(afterStart == null){
                    afterStart = node;
                    afterEnd = afterStart;
                }else{
                    //append this node to after list
                    afterEnd.next = node;
                    //afterEnd points to the new node
                    afterEnd = node;
                }
            }

            node = next;
        }

        //merge sub-list
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
