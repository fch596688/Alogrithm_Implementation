/**
 * Created by fch59 on 10/6/2017.
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * The good thing about selection sort is it never makes more than O(n) swaps
 * and can be useful when memory write is a costly operation.
 */
public class SelectionSort {
    //always find the min value, then put the value in the first position of each array
    public void selectionSort(int[] array){
        int length = array.length;
        //length - 1: number of selection of first element of the array
        for(int i = 0; i < length - 1; i++){
            int minElement = i;
            //j: position of element of each  array
            for(int j = i + 1; j < length; j++) {
                //find the value is less than minElement
                if (array[j] < array[minElement]) {
                    minElement = j;
                }
            }

            //put the min value in the first position of each array
            int temp = array[minElement];
            array[minElement] = array[i];
            array[i] = temp;
        }
    }

    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver code to test above
    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.selectionSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
