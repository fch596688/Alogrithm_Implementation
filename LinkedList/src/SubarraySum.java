import java.util.*;
public class SubarraySum {
    //Time Complexity: O(n * n);
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int startIndex = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            //Once we find the zero at the start point of a out loop, return the start point
            if (nums[i] == 0) {
                result.add(i);
                result.add(i);
                return result;
            }
            sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    result.add(startIndex);
                    result.add(j);
                    return result;
                }
            }
            sum = 0;
            startIndex++;
        }
        return result;
    }

    //Time Complexity: O(n) Space Complexity: O(n)


}
