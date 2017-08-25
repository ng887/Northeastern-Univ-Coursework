package Assignments.Assignment_03_DP;

/**
 * Created by neha on 4/2/2017.
 */
public class MinJumps {

    /*4.Print the path of minimum jump.*/
    public static int minJumps(int[] arr){

        int[] jumps = new int[arr.length];
        int[] result = new int[arr.length];

        for(int i = 1 ; i < arr.length; i ++){

            jumps[i] = Integer.MAX_VALUE;
            result[i] = Integer.MAX_VALUE;
        }

        jumps[0] = 0;
        result[0] = 0;

        for(int i = 0 ; i < arr.length; i ++){
            for(int j = 0 ; j < i ; j ++){
                if( arr[j] + j >=i ) {
                    if(jumps[i]> jumps[j] +1){

                        jumps[i] = jumps[j] +1;
                        result[i] = j;
                    }
                }
            }
        }

        int minJumps=jumps[arr.length -1];
        int[] ans= new int[minJumps+1];

        ans[minJumps]=arr.length-1;
        int pos=result.length-1;
        while(pos>0 ){
            ans[minJumps-1]=result[pos];
            minJumps --;
            pos=result[pos];
        }

        System.out.print("\npath of min jump(indexes):");
        for (int i=0;i < ans.length; i++){
            System.out.print(ans[i] + "->");
        }

        return jumps[arr.length -1];
    }

    public static void main(String[] args) {
        MinJumps m = new MinJumps();
        int[] arr={1,3,5,8,9,2,6,7,6,8,9};
        System.out.println("\nMin number of jumps req to reach the end " + m.minJumps(arr));
    }
}
