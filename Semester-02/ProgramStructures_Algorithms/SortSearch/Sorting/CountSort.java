package SortSearch.Sorting;

/**
 * Created by neha on 2/6/2017.
 */
public class CountSort {

    public static void countSort(int[] arr){
        int[] count = new int[100];

        for (int i = 0 ; i< arr.length ; i++){
            count[arr[i]]++;
        }

        int index = 0;
        for (int i = 0 ; i < 100 ; i++){
            while(count[i] > 0){
                arr[index] = i;
                count[i] --;
                index ++;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 4, 2, 8, 4, 35, 30, 35, 50, 30, 4, 2};
        countSort(arr);

        int n = arr.length;
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + ",");
    }
}
