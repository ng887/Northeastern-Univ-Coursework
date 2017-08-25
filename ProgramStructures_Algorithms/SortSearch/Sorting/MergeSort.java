package SortSearch.Sorting;

/**
 * Created by neha on 2/6/2017.
 */
public class MergeSort {
    public static void mergeSort(int arr[]) {
        int n = arr.length;
        if (n < 2) {
            return;
        } else {
            int mid = n / 2;
            int left[] = new int[mid];
            int right[] = new int[n - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }

            for (int i = mid; i < n; i++) {
                right[i - mid] = arr[i];
            }

            mergeSort(left);
            mergeSort(right);
            merge(left, right, arr);
        }

    }

    private static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        int nL = left.length;
        int nR = right.length;

        while (i < nL && j < nR) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;

            } else {
                arr[k] = right[j];
                j++;

            }
            k++;
        }

        while (i < nL) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < nR) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 4, 2, 8, 4, 35, 30, 35, 50, 30, 4, 2};
        mergeSort(arr);

        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + ",");
    }
}
