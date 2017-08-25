package SortSearch.Sorting;

/**
 * Created by neha on 2/6/2017.
 */
public class PancakeSort {
    public static void pancakeSort(int[] arr){
        int n = arr.length;
        for(int cur_size = n ; cur_size > 1 ; cur_size --){
            int maxIndex = getMaxIndex(arr,cur_size);

            if (maxIndex != cur_size -1){
                flip (arr,maxIndex);
                flip (arr,cur_size-1);
            }
        }
    }

    static void flip(int[] arr, int i){
        int temp, start = 0;
        while(start < i){
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            i --;
            start ++;
        }

    }

    static int getMaxIndex(int arr[], int n) {
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 9, 2, 8};

        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + ",");
    }
}
