/**
 * Created by fch59 on 10/20/2017.
 */
public class MergeSortedArray {
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }
        int[] temp = new int[A.length + B.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                temp[index++] = A[i++];
            } else {
                temp[index++] = B[j++];
            }
        }

        while (i < A.length) {
            temp[index++] = A[i++];
        }

        while (j < B.length) {
            temp[index++] = B[j++];
        }

        return temp;
    }
    public void mergeSortedArray2(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        int j = n - 1;
        int i = m - 1;

        while (j >= 0 && i >= 0) {
            System.out.println("i: " + i + "j: " + j);
            if(A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }

        while (i >= 0) {
            A[index--] = A[i--];
        }

        while (j >= 0) {
            A[index--] = B[j--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();
        int[] A = {9,10,11,12,13,0,0,0,0};
        int[] B = {4, 5, 6, 7};
        obj.mergeSortedArray2(A, 5, B, 4);
    }
}
