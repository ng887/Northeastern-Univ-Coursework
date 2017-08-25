package SortSearch.Sorting;

/**
 * Created by neha on 2/6/2017.
 */
public class BubbleSort {
    public static void swap(int arr[], int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 4, 2, 8, 4, 35, 30, 35, 50, 30, 4, 2};
        bubbleSort(arr);

        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + ",");
    }
}
