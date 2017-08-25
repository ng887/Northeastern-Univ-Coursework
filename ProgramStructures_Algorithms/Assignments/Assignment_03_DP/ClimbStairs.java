package Assignments.Assignment_03_DP;

/**
 * Created by neha on 4/1/2017.
 */
public class ClimbStairs {

    /* Recursive*/
    public static int numWayClimb(int n)
    {

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;

        return numWayClimb(n - 1) + numWayClimb(n - 2) + numWayClimb(n - 3);
    }

    /*Tablization*/
    /*1. Solve NumWayClimb using tablization*/
    public static int numWayClimbTablization(int n)
    {

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;

        int[] table = new int[n+1];
        table[1] = 1;
        table[2] = 2;
        table[3] = 4;

        for (int i = 4; i < table.length; i++)
        {
            table[i] = table[i - 1] + table[i - 2] + table[i-3];
        }
        return table[n];
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println("Recursive number of ways to climb stairs (max 3 at a time) is " + cs.numWayClimb(6));
        System.out.println("Tablization  number of ways to climb stairs (max 3 at a time) is " + cs.numWayClimbTablization(6));
    }
}
