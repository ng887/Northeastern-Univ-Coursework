package SortSearch.Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neha on 2/6/2017.
 */
public class RadixSort {

    static void radixSort(int[] arr) {
        int n = arr.length;
        int max = getMax(arr,n);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort1(arr, n,exp);
        }
    }


    static void countSort1(int arr[], int n, int exp){
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];


        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static int getMax(int arr[], int n){
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    //////////////////
    public static void radixSort2 (int[] arr){
        int radix =10;
        List<Integer>[] bucket = new ArrayList[radix];
        for(int i =0 ; i < bucket.length ; i++){
            bucket[i] = new ArrayList<Integer>();
        }


        boolean maxLength = false;
        int tmp = -1 ; int placement =1;
        while ( !maxLength ){
            maxLength = true;
            for(Integer i: arr){
                tmp = i /placement;
                bucket[tmp % radix].add(i);
                if(maxLength && tmp > 0){
                    maxLength = false;
                }
            }

            int a=0;
            for(int b =0 ; b < radix ; b++){
                for(Integer i: bucket[b]){
                    arr[a++] = i;
                }
                bucket[b].clear();
            }
            placement *= radix;
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 4, 2, 8, 4, 35, 30, 35, 50, 30, 4, 2};
        int n = arr.length;

        radixSort(arr);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + ",");
        radixSort2(arr);


        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + ",");
    }
}
