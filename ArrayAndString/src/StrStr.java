/*
For a given source string and a target string,
you should output the first index(from 0) of target string in source string.
If target does not exist in source, just return -1.

Example
If source = "source" and target = "target", return -1.
If source = "abcdabcdefg" and target = "bcd", return 1.
 */
public class StrStr {
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        if (source.equals("") && target.equals("")) {
            return 0;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (; j < target.length(); j++) {
                if (target.charAt(j) != source.charAt(i + j)) {
                    break;
                }
            }

            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }
}
