/**
 * Created by fch59 on 10/6/2017.
 */
public class InsertionSort {

    public void insertionSort(int[] array){
        int length = array.length;
        //find second element first
        for(int i = 1; i < length; i++){
            //if previous one is more than current one.
            if(array[i] < array[i-1]){
                int key = array[i];
                //find the position by shifting the element
                int j = i - 1;
                while(j >= 0 && array[j] > key){
                    array[j+1] = array [j];
                    j--;
                }
                //because j has been j--, so to find the right place to insert, we need to add one!!!!!!!!!!!!!!!!
                array[j+1] = key;
            }
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
