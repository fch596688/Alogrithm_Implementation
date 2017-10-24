/**
 * Created by fch59 on 10/22/2017.
 */
//三步反转法
public class RotateString {
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0 || offset < 0) {
            return;
        }

        int len = str.length;
        offset = offset % len;

        reverse(str, 0, len - offset - 1);
        reverse(str, len - offset, len - 1);
        reverse(str, 0, len - 1);
    }

    private void reverse (char[] str, int start, int end) {
        while (start < end) {
            char temp  = str[end];
            str[end] = str[start];
            str[start] = temp;
            start++;
            end--;
        }
    }
}
