package PracticeQuestions.Question02;

/**
 * Created by neha on 3/16/2017.
 */
/*
Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the
difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.
Example
Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].
Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
please analyze the time complexity.
 */


/*Time Complexity:O(Logn + k)
Binary Search to find the closest number from target in O(logn)
Once closest point is found the printing of numbers on comparison will take O{k)
Hence, O(Logn + k)
 */
public class KClosestInSortedArray {

    public int findClosest(int arr[], int start, int end, int target){
        //Base Cases
        if(arr[start] > target){
            return start;
        }
        if(arr[end] <= target){
            return end;
        }

        //mid index
        int mid = start + (end-start)/2;
        if (arr[mid] <= target && arr[mid+1] > target)
            return mid;

        if(arr[mid] < target){
            return findClosest(arr,mid+1,end,target);
        }else{
            return findClosest(arr,start,mid-1,target);
        }
    }

    public void printKClosest(int arr[], int target, int k){
        int n = arr.length;
        int closestToTarget = findClosest(arr,0,n-1,target);
        int left =  closestToTarget;
        int right = closestToTarget+1;
        int count = 0;


        while (left >= 0 && right <= n-1  && count < k) {
            if (Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
                    System.out.print(arr[left] + " ");
                    left--;
            } else {
                    System.out.print(arr[right] + " ");
                    right++;
                }
              count ++;
        }


        while (count < k && left >= 0)
        {
            System.out.print(arr[left]+" ");
            left--;
            count++;
        }

        while (count < k && right <= n-1)
        {
            System.out.print(arr[right]+" ");
            right--;
            count++;
        }
    }

    public static void main(String[] args) {
        KClosestInSortedArray val = new KClosestInSortedArray();
        int[] arr = {1,4,6,8};
        int[] arr1 = {1,2,3};
        int k =3;
        int target=3;


        System.out.println( k + " closest elements to " + target + " are:" );
        val.printKClosest(arr,target,k);

        System.out.println();
        System.out.println( k + " closest elements to " + 2 + " are:" );
        val.printKClosest(arr1,2,k);
    }

}
