package Assignments.Assignment_03_DP;

/**
 * Created by neha on 4/1/2017.
 */
public class LongestIncSubseq {

    /*3. Display the value of Longest Increasing Subsequence.*/
    public static int LongestIncreasingSubSequence(int[] arr){

        if(arr==null ||arr.length == 0){
            return 0;
        }
        int[] lis = new int[arr.length];
        for(int i = 0 ; i < lis.length; i ++){
            lis[i] = 1;
        }
        int max = 1;

        for(int i = 1; i < arr.length; i ++){

            for(int j = 0 ; j < i; j ++){

                if( arr[i]> arr[j] && lis[i] < lis[j] +1){
                    lis[i] = lis[j] +1;
                    if(max < lis[i])
                        max = lis[i];
                }
            }
        }

        int j=1;
        for(int i=0; i< arr.length; i ++){
                if(j == lis[i]){
                    System.out.print(arr[i] + ",");
                    j++;
                }
        }
        System.out.println();
        return max;
    }

    public static void main(String[] args) {
        LongestIncSubseq lis = new LongestIncSubseq();
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,15};

        System.out.println("Max length of Longest Inc Subseq is " + lis.LongestIncreasingSubSequence(arr));
    }
}
