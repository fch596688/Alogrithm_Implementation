import java.util.*;
/*
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return all possible palindrome partitioning of s.

    Given s = "aab", return:

    [
      ["aa","b"],
      ["a","a","b"]
    ]

 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        List<String> partition = new ArrayList<String>();
        helper(s, partition, 0, result);
        return result;
    }

    private void helper(String s, List<String> partition, int startIndex, List<List<String>> result) {

        if (startIndex == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String subString = s.substring(startIndex, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }

            partition.add(subString);
            helper(s, partition, i + 1, result);
            partition.remove(partition.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int i,j;
        for (i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
