
/**
 * Created by fch59 on 9/12/2017.
 */
public class TestClient {
    public int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }
            if(nums[start] < nums[mid]){
                //search monotonic increasing then binary search
                if(nums[start] <= target && nums[mid] >= target){
                    end = mid;
                }else{
                    start = mid;
                }
            } else {
                //search monotonic increasing then binary search
                if (nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        if(nums[start] == target){
            return start;
        }

        if(nums[end] == target){
            return end;
        }

        return -1;
    }

    public static void main(String[] args){
        TestClient test = new TestClient();
        int[] nums = {3,5,1};
        int[][] matrix = new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };

        int str = test.search(nums, 1);
        System.out.println(str);
    }
}
