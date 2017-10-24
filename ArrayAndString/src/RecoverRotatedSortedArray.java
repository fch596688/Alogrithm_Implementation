/**
 * Created by fch59 on 10/22/2017.
 */
import java.util.*;
public class RecoverRotatedSortedArray {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return;
        }

    //caution: index + 1 is out of bound.
        for (int index = 0; index < nums.size() - 1; index++) {
            if (nums.get(index) > nums.get(index + 1)) {
                reverse (nums, 0, index);
                reverse (nums, index + 1, nums.size() - 1);
                reverse (nums, 0, nums.size() - 1);
            }
        }
    }

    private void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp  = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start ++;
            end --;
        }
    }
}
