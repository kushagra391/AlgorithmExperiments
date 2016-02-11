package dp;/* Authored by Kushagra on 2/11/2016. */

public class MaximumSumLISDemo {

    public static void main(String[] args) {
        int[] A = {};
        int n = A.length;
        System.out.println(maximumIncreasingSum(A, n));

    }

    private static int maximumIncreasingSum(int[] A, int n) {

        int[] lis = new int[n];

        for (int i = 0; i < A.length; i++)
            lis[i] = A[i];

        int sum_j;
        for (int i = 1; i < n; i++) {

            sum_j = 0;
            for (int j = 0; j < i; j++) {

                if (A[i] > A[j]) {
                    
                }

            }
        }


        int maxSum = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            maxSum = Math.max(maxSum, lis[i]);
        }

        return maxSum;
    }

}
