import java.util.Arrays;
import java.util.Comparator;

public class SubarraySumCloset {
    public class Pair {
        int sum;
        int index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }

        // we need a for loop to calculate prefixSum and store the index;
        Pair[] sum = new Pair[nums.length + 1];
        sum[0] = new Pair(0,0);
        int prev = 0;
        for (int i = 1; i < sum.length; i++) {
            //sum 是前i项数之和， 所以下面的index要减1
            sum[i] = new Pair(prev + nums[i - 1], i);
            prev = sum[i].sum;
        }

        Arrays.sort(sum, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < sum.length; i++) {
            if (ans > sum[i].sum - sum[i - 1].sum) {
                ans = sum[i].sum - sum[i - 1].sum;
                int[] temp = new int[]{sum[i].index - 1, sum[i - 1].index - 1};
                Arrays.sort(temp);
                result[0] = temp[0] + 1;
                result[1] = temp[1];
            }
        }

        return result;
    }
}