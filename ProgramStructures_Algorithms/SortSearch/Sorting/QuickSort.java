package SortSearch.Sorting;

/**
 * Created by neha on 2/6/2017.
 */
public class QuickSort {



    public static void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex -1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pIndex = start;

        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    public static void swap(int arr[], int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 4, 2, 8, 4, 35, 30, 35, 50, 30, 4, 2};
        quickSort(arr,0,arr.length-1);

        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + ",");

    }
}
