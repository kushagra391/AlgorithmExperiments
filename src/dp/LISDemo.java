package dp;/* Authored by Kushagra on 2/10/2016. */

public class LISDemo {

    public static void main(String[] args) {

        int[] A = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(lisLength(A));

    }

    // Bottom up DP for LIS Problem
    private static int lisLength(int[] A) {

        int n = A.length;

        // init LIS array with n entries
        int[] lis = new int[n];

        // base init
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        // Bottom up DP Calculation
        // Recurrence: L(i) = 1 + max(L(j)) or 1
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // from the recurrence relation of LIS
                if (A[i] > A[j]) {
                    // update LIS only if its better than before
                    if (lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                    }
                }
            }
        }

        // Pick maximum LIS
        int maxLIS = 0;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, lis[i]);
        }

        return maxLIS;
    }

}
