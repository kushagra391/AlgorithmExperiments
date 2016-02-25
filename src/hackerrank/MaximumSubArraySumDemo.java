package hackerrank;/* Authored by Kushagra on 2/24/2016. */

/*
 * Refer:
 * http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
 */

import java.util.Scanner;

public class MaximumSubArraySumDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int size = sc.nextInt();
            int[] A = new int[size];
            for (int j = 0; j < size; j++) {
                A[j] = sc.nextInt();
            }
            maximumSubArraySum(A);
        }
    }

    private static void maximumSubArraySum(int[] A) {
        int n = A.length;
        int r1 = kadanes(A, n);
        int r2 = lisSum(A, n);

        System.out.println(r1 + " " + r2);
    }

    private static int lisSum(int[] A, int n) {
        int[] msis = new int[n];

        for (int i = 0; i < n; i++)
            msis[i] = A[i];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (A[i] >= A[j] && msis[j] + A[i] > msis[i]) {
                    msis[i] = msis[j] + A[i];
                }
            }
        }

        // pick max
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, msis[i]);
        }

        return max;
    }

    // linear time implementation of Kadane's
    private static int kadanes(int[] A, int n) {
        int currentSum = 0;
        int maxSumSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currentSum += A[i];
            if (currentSum < 0) {
                // start fresh
                currentSum = A[i];
            } else {
                maxSumSoFar = Math.max(maxSumSoFar, currentSum);
                maxSumSoFar = Math.max(maxSumSoFar, A[i]);
            }
        }

        maxSumSoFar = Math.max(maxSumSoFar, currentSum);

        int max = Integer.MIN_VALUE;
        if (allNegative(A)) {
            for (int x : A) {
                max = Math.max(max, x);
            }
            return max;
        }

        return maxSumSoFar;
    }

    private static boolean allNegative(int[] A) {

        for (int x : A) {
            if (x >= 0) {
                return false;
            }
        }

        return true;
    }
}
