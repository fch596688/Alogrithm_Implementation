public class LinkedList {

    Node head = null;

    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //add a new node in linked list
    //Time complexity of this push method is O(1)
    public void push(int newData){
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }
    //add a new node after a given node
    //Time complexity of this push method is O(1)
    public void insertAfter(int newData, Node givenNode){
        Node newNode = new Node(newData);
        newNode.next = givenNode.next;
        givenNode.next = newNode;
    }
    //add a node at the end
    public void append(int newData){
        Node newNode = new Node (newData);

        if (head == null){
            head = newNode;
        }else{
            //traverse till the last node
            Node lastNode = head;
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }
    //print linked list
    public void printLinkedList(){
        Node node = head;
        while(node != null){
            System.out.print("Node Data: " + node.data);
            node = node.next;
        }
    }

    //delete the first occurence of key in linked list
    public void deleteNode(int key){
        Node temp = head;
        Node prev = null;
        // head node is what we want to find, delete the head node
        if (temp != null && temp.data == key ){
            head = temp.next; // temp.next == null, so when head is null, this linked list will be deleted.
        }else {
            //traverse the linked list and find which node has the key
            //at the same time, keep track of the previous node
            while(temp.next != null && temp.data != key){
                prev = temp;
                temp = temp.next;
            }
            // if each node in the list doesn't contain the key, return
            if (temp == null){
                return;
            }
            //unlink the node
            prev.next = temp.next;
        }
    }
}
