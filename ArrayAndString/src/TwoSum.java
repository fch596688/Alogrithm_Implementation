import java.util.*;
/**
 * Created by fch59 on 10/22/2017.
 */
//time: O(n) extra space: O(n)
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) {
            return result;
        }

        Map<Integer, Integer> map  = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
            }
            map.put(target - numbers[i], i);
        }

        return result;
    }
}
