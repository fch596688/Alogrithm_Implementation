/**
 * Created by fch59 on 10/6/2017.
 */
public class QuickAndMergeSort {
    public void sortIntegers2(int[] A) {
        if(A == null || A.length == 0){
            return;
        }
        int[] temp = new int[A.length];
        //quickSort(A, 0, A.length - 1);
        mergeSort(A, 0, A.length - 1, temp);
    }

    private void quickSort(int[]array, int start, int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        //pick the middle element in order to avoid the worst case: 11111111111111111111
        int pivot = array[(start + end) / 2];

        //point 2: left <= right if left < right, stack overflow occurs
        while(left <= right){
            //point 3: array[left] < pivot to avoid the worst case: 11111111111111111111 O(n)
            while(left <= right && array[left] < pivot){
                left ++;
            }

            while(left <= right && array[right] > pivot){
                right --;
            }

            if(left <= right){
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
                left ++;
                right --;
            }
        }

        quickSort(array, start, right);
        quickSort(array, left, end);
    }

    private void mergeSort(int[]array, int start, int end, int[] temp){
        if (start >= end){
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(array, start, mid, temp);
        mergeSort(array, mid + 1, end, temp);
        merge(array, start, end, temp);
    }
    //merge array[first...mid] and array[mid+1,.....last]
    private void merge(int[] array, int start, int end, int[] temp){
        int mid = (start + end) / 2;
        int left = start;
        int right = mid + 1;
        //start from left;
        int index = left;
        //find the smaller value and put it into temp
        while(left <= mid && right <= end){
            if(array[left] < array[right]){
                temp[index++] = array[left++];
            }else{
                temp[index++] = array[right++];
            }
        }
        //put all element into temp in the rest of left part
        while(left <= mid){
            temp[index++] = array[left++];
        }
        //put all element into temp in the rest of right part
        while(right <= end){
            temp[index++] = array[right++];
        }
        //copy each element in temp to array
        for(int i = start; i <= end; i++){
            array[i] = temp[i];
        }
    }
}
