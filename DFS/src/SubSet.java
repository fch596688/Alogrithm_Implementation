import java.util.*;
/*
    Given a set of distinct integers, return all possible subsets.
 */
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);

        helper(nums, subSet, 0, result);

        return result;
    }

    private void helper (int[]nums,
                         List<Integer>subSet,
                         int startIndex,
                         List<List<Integer>> result) {
        result.add(new ArrayList<>(subSet));


        for (int i = startIndex; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i-1] && i != startIndex) {
                continue;
            }
            subSet.add(nums[i]);
            helper(nums, subSet, i + 1, result);
            subSet.remove(subSet.size() - 1);
        }

    }

    public static void main (String[] args) {
        SubSet obj = new SubSet();
        int[] arr = new int[0];
        List<List<Integer>> list = obj.subsets(arr);
        System.out.println(list);
    }
}
