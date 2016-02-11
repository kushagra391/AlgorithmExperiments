package dp;/* Authored by Kushagra on 2/11/2016. */

public class SubsetSumDemo {
    public static void main(String[] args) {
        int[] A = {3, 34, 4, 12, 5, 2};
        int S = 13;

        System.out.println(SubsetSum(A, A.length, S));

    }


    /* Recursive Solution:
     * Either x would contribute to the sum,
     * or it, wont.
     * isSubsetSum(set, n, S) =
     * i. isSubsetSum (set, n-1, S - x)
     * ii. isSubsetSum(set, n-1, S)
    */
    private static boolean SubsetSum(int[] set, int n, int sum) {

        if (sum == 0) return true;
        if (n == 0) return false;

        return SubsetSum(set, n-1, sum) || SubsetSum(set, n-1, sum - set[n-1]);
    }
}
