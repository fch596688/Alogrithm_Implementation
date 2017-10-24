import java.util.*;
/**
 * Created by fch59 on 10/22/2017.
 */
public class TwoSumDataStructureDesign {
    List<Integer> list = new ArrayList<>();
    public void add(int number) {
        list.add(number);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        int size = list.size();
        if (size < 2) {
            return false;
        }

        Collections.sort(list);
        int start = 0;
        int end = size - 1;
        while (start < end) {
            int sum = list.get(start) + list.get(end);
            if (sum < value) {
                start++;
            } else if (sum > value) {
                end--;
            } else {
                return true;
            }
        }

        return false;
    }
}
