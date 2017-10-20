import java.util.*;
/*
    Given a collection of integers that might contain duplicates, nums, return all possible subsets.
    Note: The solution set must not contain duplicate subsets.

    For example,
    If nums = [1,2,2], a solution is:

    [
      [2],
      [1],
      [1,2,2],
      [2,2],
      [1,2],
      []
    ]

 */
public class Subset2 {
    int k = 1;
    int y = 1;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<>();

        helper(nums, 0, subset, result);

        return result;
    }

    private void helper (int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            System.out.println("subset: "+ subset.toString() + "("+ i + "---" + startIndex + ")");
            //if nums[i - 1] has been put into subset, it will be fine. In this call, startindex = i - 1 + 1 = i;
            //if nums[i - 1] is not put into subset, it won't be that startIndex will equal i;
            if (i != 0 && nums[i] == nums[i-1] && i != startIndex) {
                continue;
            }

            subset.add(nums[i]);

            helper(nums, i + 1, subset, result);

            subset.remove(subset.size() - 1);

        }
    }

    public static void main (String[] args) {
        Subset2 obj = new Subset2();
        int[] arr = new int[] {1,2,2};
        List<List<Integer>> list = obj.subsetsWithDup(arr);
        System.out.println(list);
    }
}
