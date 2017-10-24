/**
 * Created by fch59 on 10/21/2017.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        //calculate prefixSum and store minSum
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
        }

        return max;
    }
}
