/**
 * Created by fch59 on 10/22/2017.
 */
public class TwoSumInSortedArray {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum < target) {
                start ++;
            } else if (sum > target) {
                end --;
            } else {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
        }

        return result;
    }
}
