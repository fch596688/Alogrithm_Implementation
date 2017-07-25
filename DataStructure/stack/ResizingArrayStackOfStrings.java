/**
 * Created by fch59 on 7/9/2017.
 * double the size of array when array is full
 * halve the size of array when array is one-quarter full
 * So array is between 25% and 100% full.
 * Vector resizing
 *
 * A vector resizes itself dynamically as needed.
 * It does that by allocating a new chunk of memory, moving (or copying) data from the old chunk to the new chunk,the releasing the old one.
 * In a typical case, the new chunk is 1.5x the size of the old (contrary to popular belief, 2x seems to be quite unusual in practice).
 * That means for a short time while reallocating, it needs memory equal to roughly 2.5x as much as the data you're actually storing.
 * The rest of the time, the "chunk" that's in use is a minimum of 2/3rds full, and a maximum of completely full.
 * If all sizes are equally likely, we can expect it to average about 5/6ths full.
 * Looking at it from the other direction, we can expect about 1/6th, or about 17% of the space to be "wasted" at any given time.
 * When we do resize by a constant factor like that (rather than, for example, always adding a specific size of chunk, such as growing in 4Kb increments) we get what's called amortized constant time addition.
 * !!!!In other words, as the array grows, resizing happens exponentially less often. !!!!
 * The average number of times items in the array have been copied tends to a constant (usually around 3, but depends on the growth factor you use).

 * linked list allocations
 *
 * Using a linked list, the situation is rather different. We never see resizing, so we don't see extra time or memory usage for some insertions.
 * At the same time, we do see extra time and memory used essentially all the time.
 * In particular, each node in the linked list needs to contain a pointer to the next node.
 * Depending on the size of the data in the node compared to the size of a pointer, this can lead to significant overhead.
 * For example, let's assume you need a stack of ints.
 * In a typical case where an int is the same size as a pointer, that's going to mean 50% overhead -- all the time.
 * It's increasingly common for a pointer to be larger than an int; twice the size is fairly common (64-bit pointer, 32-bit int).
 * In such a case, you have ~67% overhead -- i.e., obviously enough, each node devoting twice as much space to the pointer as the data being stored.
 * Unfortunately, that's often just the tip of the iceberg. In a typical linked list, each node is dynamically allocated individually.
 * At least if you're storing small data items (such as int) the memory allocated for a node may be (usually will be) even larger than the amount you actually request.
 * So -- you ask for 12 bytes of memory to hold an int and a pointer -- but the chunk of memory you get is likely to be rounded up to 16 or 32 bytes instead.
 * Now you're looking at overhead of at least 75% and quite possibly ~88%.
 * As far as speed goes, the situation is rather similar: allocating and freeing memory dynamically is often quite slow.
 * The heap manager typically has blocks of free memory, and has to spend time searching through them to find the block that's most suited to the size you're asking for.
 * Then it (typically) has to split that block into two pieces, one to satisfy your allocation, and another of the remaining memory it can use to satisfy other allocations.
 * Likewise, when you free memory, it typically goes back to that same list of free blocks and checks whether there's an adjoining block of memory already free, so it can join the two back together.
 * Allocating and managing lots of blocks of memory is expensive.

 * cache usage
 * Finally, with recent processors we run into another important factor: cache usage.
 * In the case of a vector, we have all the data right next to each other.
 * Then, after the end of the part of the vector that's in use, we have some empty memory.
 * This leads to excellent cache usage -- the data we're using gets cached;
 * the data we're not using has little or no effect on the cache at all.
 * With a linked list, the pointers (and probable overhead in each node) are distributed throughout our list.
 * I.e., each piece of data we care about has, right next to it, the overhead of the pointer, and the empty space allocated to the node that we're not using.
 * In short, the effective size of the cache is reduced by about the same factor as the overall overhead of each node in the list
 * -- i.e., we might easily see only 1/8th of the cache storing the date we care about, and 7/8ths devoted to storing pointers and/or pure garbage.

 Summary

 *A linked list can work well when you have a relatively small number of nodes, each of which is individually quite large.
 *If (as is more typical for a stack) you're dealing with a relatively large number of items, each of which is individually quite small, you're much less likely to see a savings in time or memory usage.
 * Quite the contrary, for such cases, a linked list is much more likely to basically waste a great deal of both time and memory.
 */
public class ResizingArrayStackOfStrings {
    private String[] s;
    private int N = 0;

    public boolean isEmpty(){
        return N == 0;
    }

    public ResizingArrayStackOfStrings(){
        s = new String[1];
    }
    public void push(String item){
        if (N == s.length) resize(s.length*2);
        else s[N++] = item;
    }

    public String pop(){
        String item = s[--N];
        if (N > 0 && N == s.length/4) resize( s.length/2);
        return item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < s.length; i++){
            copy[i] = s[i];
        }
        s = copy;
    }
}
