package SortSearch.Searching;

import java.io.Console;
import java.util.Arrays;

/**
 * Created by neha on 1/17/2017.
 */
public class Search {
    public static int binarySearch (int[] arr, int x) {
        int start = 0;
        int end = arr.length -1;


        while (start <= end){
            int mid = (start+end) /2;
            if (arr[mid] == x){
                return mid;
            }
            else if (arr[mid] > x){
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return -1;

    }
    public static int binarySearchRecursive(int[] arr, int x){

        return binarySearchRecursiveHelper(arr,  x, 0, arr.length -1);
    }
    private static int binarySearchRecursiveHelper(int[] arr, int x, int start, int end) {
        if (start > end){
            return -1;
        }
        int mid = (start+end) /2;

        if (arr[mid] == x){
            return mid;
        }
        else if ( arr[mid] > x){
            return binarySearchRecursiveHelper (arr, x, start,  mid -1);
        }
        else {
            return binarySearchRecursiveHelper (arr, x, mid+1,  end);
        }
    }

    static int findMinRotated(int[] arr)
    {

        int low = 0;
        int high = arr.length - 1;

        while (arr[low] > arr[high])
        {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[high])
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }

        }

        return arr[low];

    }

    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }

    public int findMin(int[] num, int left, int right) {
        if (left == right)
            return num[left];
        if ((right - left) == 1)
            return Math.min(num[left], num[right]);

        int middle = left + (right - left) / 2;

        // not rotated
        if (num[left] < num[right]) {
            return num[left];

            // go right side
        } else if (num[middle] > num[left]) {
            return findMin(num, middle, right);

            // go left side
        } else {
            return findMin(num, left, middle);
        }
    }

   // Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[].
    // Expected time complexity is O(Logn)

    public static int getOccurences (int[] arr, int x){
        return getOccurencesHelper ( arr, x, 0 ,  arr.length -1);


    }
    private static int getOccurencesHelper(int[] arr, int x, int start, int end) {
        if (start > end){
            return 0;
        }

        if (arr[start] > x){
            return 0;
        }

        if (arr[end] < x){
            return 0;
        }

        if ((arr[start] == x) && (arr[end] == x)){
            return end - start +1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == x){
            return (1 + getOccurencesHelper(arr, x, start, mid -1)
                    + getOccurencesHelper(arr, x, mid +1, end));
        }
        else if (arr[mid] < x){
            return getOccurencesHelper(arr, x, mid +1, end);
        }
        else {
            return getOccurencesHelper(arr, x, start, mid -1);

        }

    }

    public static int getFirstOccurence (int[] arr, int x){
        return getFirstOccurenceHelper ( arr, x, 0 ,  arr.length -1);


    }
    private static int getFirstOccurenceHelper(int[] arr, int x, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (arr[start] > x) {
            return 0;
        }

        if (arr[end] < x) {
            return 0;
        }

        if ((arr[start] == x) && (arr[end] == x)) {
            return end - start + 1;
        }

        int mid = (start + end) / 2;
        if (arr[mid] == x) {
            if (arr[mid - 1] < x)
                return mid;
            else {
                return getFirstOccurenceHelper(arr, x, start, mid - 1);
            }
        }
         else if (arr[mid] < x) {
            return getFirstOccurenceHelper(arr, x, mid + 1, end);
        } else {
            return getFirstOccurenceHelper(arr, x, start, mid - 1);

        }

    }

    //Has complexity of o(n)
    public static boolean findElementInSortedMatrix(int[][] matrix, int x) {

        int n = matrix.length;
        int row = 0;
        int col = n - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == x) {
                System.out.println("Element found in [" + row + "][" + col + "]");
                return true;
            } else if (matrix[row][col] > x) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    /*
    public static void findElementInSortedMatrixBS (int[][] matrix,int fromRow, int toRow,int fromCol, int toCol, int key)
    {
        // Find middle and compare with middle
        int i = fromRow/2 + toRow/2;
        int j = fromCol/2 + toCol/2;
        if (matrix[i][j] == key) // If key is present at middle
            System.out.println("Found "+ key + " at "+ i + " " + j);
        else
        {
            // right-up quarter of matrix is searched in all cases.
            // Provided it is different from current call
            if (i!=toRow || j!=fromCol)
                findElementInSortedMatrixBS(matrix,fromRow,i,j,toCol,key);


            // Special case for iteration with 1*2 matrix
            // mat[i][j] and mat[i][j+1] are only two elements.
            // So just check second element
            if (fromRow == toRow && fromCol + 1 == toCol)
                if (matrix[fromRow][toCol] == key)
                    System.out.println("Found "+ key+ " at "+
                            fromRow + " " + toCol);

            // If middle key is lesser then search lower horizontal
            // matrix and right hand side matrix
            if (matrix[i][j] < key)
            {
                // search lower horizontal if such matrix exists
                if (i+1<=toRow)
                    findElementInSortedMatrixBS(matrix, i+1, toRow, fromCol, toCol, key);
            }

            // If middle key is greater then search left vertical
            // matrix and right hand side matrix
            else
            {
                // search left vertical if such matrix exists
                if (j-1>=fromCol)
                    findElementInSortedMatrixBS(matrix, fromRow, toRow, fromCol, j-1, key);
            }
        }
    }
    */

    public static boolean binSearchOnMatrix(int matrix[][], int key)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m*n-1;

        while(start<=end){
            int mid=(start+end)/2;
            int midX=mid/n;
            int midY=mid%n;

            if(matrix[midX][midY]==key)
                return true;

            if(matrix[midX][midY]<key){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }

    public static int findFirstBiggerThanK(int[] arr, int k){
        int result = -1;
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            int mid = start/2 + end/2;

            if (arr[mid] > k){
                result = arr[mid];
                end = mid - 1;
            }
            else{
                start = mid +1;
            }
        }
        return result;
    }

    public static int findCeiling(int[] arr, int x){
        return findCeilingHelper(arr,0,arr.length-1,x);
    }
    private static int findCeilingHelper(int[] arr, int start, int end, int x) {
        if(arr[start] > x){
            return start;
        }

        if(arr[end] < x){
            return -1;
        }

        int mid = start/2 + end/2;

        if(arr[mid] == x ){
            return mid;
        }
        else if (arr[mid] < x){
            if(mid+1 <= end && arr[mid +1] > x)
                return mid+1;
            else
                return findCeilingHelper(arr,mid+1,end,x);
        }
        else{
            if(mid-1 >= start && arr[mid -1] < x)
                return mid -1;
            else
                return findCeilingHelper(arr,start,mid-1,x);

        }


    }

    public static void findIntersection(int[] arr01, int[] arr02){
        int ptr01=0;
        int ptr02=0;

        while(ptr01 < arr01.length && ptr02 < arr02.length){
            if(arr01[ptr01] == arr02[ptr02]){
                System.out.print(arr01[ptr01] + " ");
                ptr01 ++;
                ptr02 ++;
            }
            else if (arr01[ptr01] < arr02[ptr02]){
                ptr01 ++;
            }
            else{
                ptr02 ++;
            }
        }

    }
    public static void findIntersectionRecursion(int[] arr01, int[] arr02){

    }

    public static void findPairSumEqualToX(int[] arr, int x){

        int start = 0;
        int end = arr.length -1;

        while(start < end){
            int sum = arr[start] + arr[end];

            if(sum == x){
                System.out.println("Pair found " + arr[start] + "," + arr[end]);
                return;
            }
            else if(sum > x){
                end --;
            }
            else{
                start ++;
            }
        }
        System.out.println("No pair found");
    }
    public static void findPairSumClosestToX(int[] arr, int x){
        int start = 0;
        int end = arr.length -1;
        int finalStart = 0;
        int finalEnd = arr.length -1;
        int diff = Integer.MAX_VALUE;


        while(start < end){

            if(Math.abs(arr[start] + arr[end] - x) < diff){
                diff = Math.abs(arr[start] + arr[end] - x);
                finalStart = start;
                finalEnd = end;
            }
            if(arr[start] + arr[end] > x){
                end --;
            }
            else{
                start++;
            }
        }
        System.out.println("The pair with sum closest to " + x + " is " + arr[finalStart] + "," + arr[finalEnd]);
    }

    //The point before which elements are smaller than or equal to X and after which elements are greater
    //Time Complexity: O(n)
    public static int findCrossover(int[] arr, int x, int start, int end){
        if(arr[start] > x){
            return start;
        }

        if(arr[end] < x){
            return end;
        }

        int mid = start/2 + end/2;

        /* If x is same as middle element, then return mid */
       if(arr[mid] <= x && arr[mid+1] > x){
           return mid;
       }
       if (arr[mid] < x){
           return findCrossover(arr,x,mid+1,end);
       }
       else{
           return findCrossover(arr,x,start,mid-1);
       }
    }
    public static void printKClosestToX(int arr[],int x,int k){
        int n = arr.length;
        int start = findCrossover(arr,x,0,n -1);
        int end = start +1;
        int count =0;

        if(arr[start] == x){
            start --;
        }

        while(start >= 0 && end < n && count < k){
            if(x - arr[start] < arr[end] - x){
                System.out.print(arr[start--]+ " ");
            }
            else{
                System.out.print(arr[end++] + " ");
            }
            count++;
        }

        while(count < k && start >= 0){
            System.out.print(arr[start--]+ " ");
            count++;
        }

        while(count < k && end < n){
            System.out.print(arr[end++]+ " ");
            count++;
        }

    }

    /*Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
    Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].*/
    public static int searchXinAlmostSorted(int[] arr,int x, int start,int end){
        if (end>=start){
            int mid = start/2 + end/2;
            if(arr[mid] == x){
                return mid;
            }
            if(mid > start && arr[mid-1] == x){
                return (mid -1);
            }
            if(mid < end && arr[mid+1] == x){
                return (mid+1);
            }

            if(arr[mid] > x){
                return searchXinAlmostSorted (arr,x,start,mid-1);
            }
            else{
                return searchXinAlmostSorted (arr,x,mid+1,end);
            }
        }
        return -1;
    }

    /*Without Duplicates*/
    public static int countAllPairsSumEqualToX(int arr[], int x){
        int count = 0 ;
        for(int i =0; i < arr.length -1; i++){
            boolean result = binarySearch(arr,x - arr[i], i+1,arr.length -1);
            if(result == true)
                count++;
        }
        return count;
    }
    private static boolean binarySearch(int arr[],int x, int start,int end){
        if (start <= end)
        {
            int mid = (start + end) / 2;
            if (arr[mid] == x)
                return true;
            else if (arr[mid] < x)
                return binarySearch(arr,x,mid+1,end);
            else
                return binarySearch(arr,x,start,mid-1);
        }
        return false;
    }

    static void GenerateMarySequence(int n, int m)
    {
        if (n <= 0)
            return;
        int[] result = new int[n];
        GenerateMarySequence(result, 0, m);
    }
    static void GenerateMarySequence(int[] result, int current, int m)
    {
        if (current == result.length)
        {
            PrintArray(result);
            return;
        }

        for (int i = 0; i < m; i++)
        {
            result[current] = i;
            GenerateMarySequence(result, current + 1, m);
        }

    }

    static void PrintArray(int[] result)
    {
        for  (int i: result)
            System.out.print(i + " ");
        System.out.println();
    }


    public static void main(String[] args) {

        int[] arr = new int[] { 6, 1, 3, 2, 8,7,5,5}; //{ 5, 1, 4, 2, 8,4,35,30,35,50,30,4,2 }

        int[] arr01 = new int[] {1,1,3,5,5}; //6,6,7,8};
        int[] arr02 = new int[] {1,2,5 }; //,5,6,6,8,10,11,12};
        int[] arr03 = new int[]  {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
        int[] arr04 = new int[] {0,2, 4, 3, 5, 7,8,9};
        int[] arr05 = new int[] {3, 2, 10, 4, 40};

        Arrays.sort(arr);   // {1,2,2,4,4,4,5,8,30,30,35,35,50} (index are 0 to 12)
        int n = arr.length;

        int [][] matrix = new int[][]{
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50},
        };



        /*for (int i = 0 ; i < n ; i ++)
            System.out.print(arr[i]+",");*/
        int x =5;
        //System.out.println(x + " is in Binary Searching.Search at index " + binarySearch(arr,x));
        // System.out.println(x + " is in Binary Searching.Search Recursive at index " + binarySearchRecursive(arr,x));
        //System.out.println("min rotated for array " + findMinRotated(arr01));
        //System.out.println(x + " occurs " + getOccurences(arr,x) + " times.");
        // System.out.println(x + " first occurs at intdex " + getFirstOccurence(arr,x) );
        //findElementInSortedMatrix(matrix,29);
        //findElementInSortedMatrixBS(matrix,0,3,0,3,29);
       // System.out.println(binSearchOnMatrix(matrix,29));
        //System.out.println(matrix.length);
        //System.out.println(findFirstBiggerThanK(arr01,6));
        //System.out.println(findCeiling(arr01,7));
        //findIntersection(arr01,arr02);
        //findPairSumEqualToX(arr01,8);
        //findPairSumClosestToX(arr01,7);
        //System.out.println(findCrossover(arr01,3,0,4));
        //printKClosestToX(arr03,35,4);
        //System.out.println(countAllPairsSumEqualToX(arr04,7));
        //System.out.println(searchXinAlmostSorted(arr05,4,0,4));
        GenerateMarySequence(2,2);

    }
}
