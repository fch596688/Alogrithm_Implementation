/**
 * Created by fch59 on 10/22/2017.
 */
import java.util.*;
public class RemoveDuplicateNumbersInArray {
    //Time: O(n) Space O(n) extra space
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        int i = 0;
        for (Integer num: set) {
            nums[i++] = num;
        }
        return set.size();
    }

    //jiuzhang HashMap

    public int deduplication9z (int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Boolean> map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        int i = 0;
        for (Map.Entry<Integer, Boolean> entry: map.entrySet()) {
            nums[i++] = entry.getKey();
        }

        return i;
    }
    //Time: O(nlogn) Space O(1)
    public int deduplication2 (int[]nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
