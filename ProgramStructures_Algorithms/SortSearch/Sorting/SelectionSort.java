package SortSearch.Sorting;

/**
 * Created by neha on 2/6/2017.
 */
public class SelectionSort {


    public static void selectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int iMin = i;
            for (int j = i+1 ;j < n; j++) {
                if (arr[j] < arr[iMin]) {
                    iMin = j; //checked
                }
                swap(arr, i, iMin);
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 4, 2, 8, 4, 35, 30, 35, 50, 30, 4, 2};
        selectionSort(arr);
    }
}
