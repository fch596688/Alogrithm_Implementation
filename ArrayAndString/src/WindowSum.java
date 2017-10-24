/**
 * Created by fch59 on 10/22/2017.
 */
public class WindowSum {
    /*
    先看例子，如果我们要返回一个sums的数组，那么这个数组应该是这样的
       sums[0] 1 + 2 + 7                  = nums[0] + nums[1] + nums[2]   （加k次，也就是第一个window）
       sums[1] 1 + 2 + 7 - 1 + 8       = sums[0] - nums[0] + nums[0 + 3] （第二个window）
       sums[2] 2 + 7 + 8 - 2 + 5       = sums[1] - nums[1] + nums[1 + 3] （第三个window）
    */
    public int[] winSum(int[] nums, int k) {
        if ( nums == null || k <= 0 || nums.length == 0) {
            return new int[0];
        }

        int[] sum =  new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            sum[0] += nums[i];
        }

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] - nums[i - 1] + nums[i + k - 1];
        }

        return sum;
    }
}
