import java.util.*;
/*
    Given a collection of candidate numbers (C) and a target number (T), f
    ind all unique combinations in C where the candidate numbers sums to T.
    Each number in C may only be used once in the combination.

    Given candidate set [10,1,6,7,2,1,5] and target 8,

    A solution set is:

    [
      [1,7],
      [1,2,5],
      [2,6],
      [1,1,6]
    ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num.length == 0 || num == null) {
            return result;
        }

        Arrays.sort(num);

        dfsHelper(num, new ArrayList<>(), 0, target, result);

        return result;
    }

    private void dfsHelper( int[] num,
                            List<Integer> combination,
                            int startIndex,
                            int remainTarget,
                            List<List<Integer>> result) {
        if (remainTarget == 0) {
            result.add(new ArrayList<>(combination));
        }

        for (int i = startIndex; i < num.length; i++) {
            if(i != 0 && num[i] == num[i - 1] && i != startIndex){
                continue;
            }

            if (remainTarget < num[i]) {
                break;
            }

            combination.add(num[i]);
            dfsHelper(num, combination, i + 1, remainTarget - num[i], result);
            combination.remove(combination.size() - 1);
        }
    }
}
