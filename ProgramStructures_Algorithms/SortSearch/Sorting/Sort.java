package SortSearch.Sorting;

import sun.reflect.misc.ReflectUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by neha on 1/12/2017.
 */
public class Sort {


    public static void swap(int arr[], int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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


    public static void findKSmallest(int[] arr, int start, int end, int k) {

        if (k > 0 && k <= end - start + 1) {
            int pIndex = partition(arr, start, end);
            if (pIndex -start   == k-1) {
                System.out.println(k + "th smallest element is " + arr[pIndex ]);
            }
            if (pIndex -start  > k-1) {
                findKSmallest(arr, start, pIndex -1, k);

            } else {
                findKSmallest(arr, pIndex + 1, end, k-pIndex+start-1);

            }
            return;
        }

    }


    public static void findKFromEnd(int[] arr, int start, int end, int k) {

        if (start < end) {
            int pIndex = partition(arr, start, end);
            if (pIndex == arr.length - k) {
                System.out.println(k + "th largest element is " + arr[pIndex]);
                return;
            }
            findKFromEnd(arr,start,pIndex-1,k);
            findKFromEnd(arr,pIndex+1,end,k);
            }
        }

    public static void main(String[] args) {

        int[] arr = new int[] { 5, 1, 4, 2, 8,4,35,30,35,50,30,4,2 };
        int[] arr1 = new int[] { 5, 1, 9, 2, 8 };
        //bubbleSort(arr);
        //selectionSort(arr);
        //insertionSort(arr);
        //mergeSort(arr);
        //quickSort(arr,0,5);
       //findKSmallest(arr1,0,4,3); // check doesnt work
       // findKFromEnd(arr1,0,4,3); // check doesnt work
        //countSort(arr);
        //radixSort(arr);
       // radixSort2(arr);
        //pancakeSort(arr1);
       // System.out.println(getMaxIndex(arr1,5));

        int n = arr1.length;
        for (int i = 0 ; i < n ; i ++)
        System.out.print(arr1[i]+",");

        /*
        System.out.println();
        int n1 = arr1.length;
        for (int i = 0 ; i < n1 ; i ++)
            System.out.print(arr1[i]+","); */
    }
}