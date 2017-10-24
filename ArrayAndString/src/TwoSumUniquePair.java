import java.util.Arrays;

/**
 * Created by fch59 on 10/23/2017.
 */
public class TwoSumUniquePair {
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                start++;
                end--;
                count++;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }

                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }

        }
        return count;
    }
}
