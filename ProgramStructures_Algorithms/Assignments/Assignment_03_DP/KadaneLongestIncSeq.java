package Assignments.Assignment_03_DP;

/**
 * Created by neha on 4/1/2017.
 */
public class KadaneLongestIncSeq {

    public static int kadane(int[] arr) {

        int maxSofar = 0;
        int maxEndingHere = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEndingHere += arr[i];
            if (maxEndingHere < 0)
                maxEndingHere = 0;
            if (maxSofar < maxEndingHere)
                maxSofar = maxEndingHere;

        }

        return maxSofar;
    }


    /*2. Find starting index an ending index of Kadane. */
    public void kadaneStartEnd(int[] arr) {

        int maxSofar = 0;
        int maxEndingHere = 0;
        int start, end;
        start= 0;
        end = 0;

        int curEnd = 0;
        int curStart = 0;

        for (int i = 0; i < arr.length; i++) {

            maxEndingHere += arr[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                curStart = i+1;
            }

            if (maxSofar < maxEndingHere) {
                maxSofar = maxEndingHere;
                end = i;
                start=curStart;
            }
        }

        System.out.println("Start Index:" + start );
        System.out.println("End Index:" + end );
    }

    public static void main(String[] args) {
        KadaneLongestIncSeq k = new KadaneLongestIncSeq();
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Sum of longest inc sequence is " + k.kadane(arr));
        System.out.println("Start index and end index of longest inc sequence is ");
        k.kadaneStartEnd(arr );

    }
}
