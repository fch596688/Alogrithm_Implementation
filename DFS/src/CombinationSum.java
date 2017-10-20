import java.util.Arrays;
import java.util.*;
/*
    Given a set of candidate numbers (C) and a target number (T),
    find all unique combinations in C where the candidate numbers sums to T.
    The same repeated number may be chosen from C unlimited number of times.
    Notice
    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }
        //1. delete duplicate and sort
        int[] newCandidates = deleteDuplicate(candidates);
        //2. dfs
        dfsHelper(newCandidates, new ArrayList<>(), 0, target, result);

        return result;
    }

    private void dfsHelper( int[] candidates,
                            List<Integer> combination,
                            int startIndex,
                            int remainTarget,
                            List<List<Integer>> result) {

        if (remainTarget == 0) {
            //deep copy!!!!!!!!!!!!!!
            result.add(new ArrayList<>(combination));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (remainTarget < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            dfsHelper(candidates, combination, i, remainTarget - candidates[i], result);
            combination.remove(combination.size() - 1);
        }
    }

    private int[] deleteDuplicate(int[] candidates) {
        Arrays.sort(candidates);

        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (candidates [i] != candidates [index]) {
                candidates[++index] = candidates[i];
            }
        }

        int [] newArray = new int[index + 1];

        for(int i = 0; i < newArray.length; i++) {
            newArray[i] = candidates[i];
        }

        return newArray;
    }
}
