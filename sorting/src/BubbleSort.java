/**
 * Created by fch59 on 10/6/2017.
 * Worst and average case time complexity: O(n * n).
 * Worst case occurs when array is reverse sorted.
 * Best case occurs when array is already sorted.
 * Space Complexity is O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 */
public class BubbleSort {
    public void bubbleSorting(int[] array){
        int length = array.length;
        for(int i = 0; i < length - 1; i++){
            //after an out loop, the largest or smallest value has been put the last position of array
            for(int j = 0; j < length - 1 - i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[])
    {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 22, 22, 11, 90};
        ob.bubbleSorting(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
