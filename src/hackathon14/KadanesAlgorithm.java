package hackathon14;/* Authored by Kushagra on 2/14/2016. */

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] A = {5, 4, -13, 11, 2, -9};
        kadanes(A);
    }

    private static void kadanes(int[] A) {
        int n = A.length;

        int currentSum = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            int x = A[i];

            currentSum = currentSum + x;

            // restart
            if (x > 0) {
                maxSoFar = Math.max(maxSoFar, currentSum);
                currentSum = 0;
            }

        }

        System.out.println(maxSoFar);
        return;
    }
}
