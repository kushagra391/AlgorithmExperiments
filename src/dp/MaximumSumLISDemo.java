package dp;/* Authored by Kushagra on 2/11/2016. */

public class MaximumSumLISDemo {

    public static void main(String[] args) {
        int[] A = {};
        int n = A.length;
        System.out.println(maximumIncreasingSum(A, n));

    }

    private static int maximumIncreasingSum(int[] A, int n) {

        int[] sumLIS = new int[n];
        System.arraycopy(A, 0, sumLIS, 0, A.length);

        int sum_j;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    // when do you update the sum
                    if (sumLIS[i] > sumLIS[j] + A[i])
                        sumLIS[i] = sumLIS[j] + A[i];
                }
            }
        }

        int maxSum = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            maxSum = Math.max(maxSum, sumLIS[i]);
        }

        return maxSum;
    }

}
