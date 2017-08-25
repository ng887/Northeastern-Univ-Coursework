package Assignments.Assignment_03_DP;

/**
 * Created by neha on 4/2/2017.
 */
public class LongestCommonSubstring {

    /*5. Find the max common substring of three strings*/
    public int LongestCommonSubstring(char[] arr1, char[] arr2, char[] arr3){
        int[][][] matrix = new int[arr1.length+1][arr2.length+1][ arr3.length+1];
        int max =0;

        for(int i = 1  ; i <= arr1.length; i ++) {
            for (int j = 1; j <= arr2.length; j++) {
                for (int k = 1; k <= arr3.length; k++) {

                    if (arr1[i - 1] == arr2[j - 1] && arr2[j - 1] == arr3[k - 1]) {
                        matrix[i][j][k] = matrix[i - 1][j - 1][k - 1] + 1;
                        if (max < matrix[i][j][k]) {
                            max = matrix[i][j][k];
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        char[] arr1="Happy Toy Game".toCharArray();
        char[] arr2="Happy Game".toCharArray();
        char[] arr3="Happy".toCharArray();

        System.out.println("The length of Longest Common substring in 3 strings is: " + lcs.LongestCommonSubstring(arr1,arr2,arr3));
    }
}
