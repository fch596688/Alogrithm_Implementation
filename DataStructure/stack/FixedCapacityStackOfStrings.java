/**
 * Created by fch59 on 7/9/2017.
 * array implementation
 */
public class FixedCapacityStackOfStrings {
    private String[] s;
    private int N = 0;

    public FixedCapacityStackOfStrings(int capacity){
        s = new String[capacity];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        s[N++] = item;
    }

    public String pop() {

        String item = s[--N];
        //avoid loitering: holding a reference to an object when it is no longer needed.
        //So garbage collector can reclaim memory only if no outstanding references.
        s[N] = null;
        return item;
    }
}
