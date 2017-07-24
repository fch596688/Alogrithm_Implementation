package stack;

import java.util.Iterator;


/**
 * Created by fch59 on 7/9/2017.
 * Stack is last in first out.
 * linked-list implementation
 */
public class Stack<Item> implements Iterable<Item>{

    private Node first = null;


    public Iterator<Item> iterator() {
        return new ListIterator() {
        };
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){ return current != null;}
        public void remove(){}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item item){
        //make first node pointer point to oldFirst;
        Node oldFirst = first;
        //create a new first node
        first = new Node();
        //assign String item;
        first.item = item;
        //!Important make the new first node point to the old first node
        first.next = oldFirst;
    }

    public Item pop(){
        Item item = first.item;
        //!Important make first node pointer to the next node;
        first = first.next;
        return item;
    }
}
