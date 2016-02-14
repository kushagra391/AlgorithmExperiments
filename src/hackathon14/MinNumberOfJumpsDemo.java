package hackathon14;/* Authored by Kushagra on 2/14/2016. */

public class MinNumberOfJumpsDemo {
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = A.length;
        System.out.println(minJumps(A, 0, n -1));
        System.out.println(_minJumps(A, 0, n -1));
    }

    private static int minJumps(int[] A, int low, int high) {

        if (low >= high) return 0; // Base condition 1 [goal reached]

        int jumpSize = A[low];
        if (jumpSize == 0) return Integer.MAX_VALUE; // Base condition 2 [result not possible]

        // Recurrence
        int minJumps = Integer.MAX_VALUE;
        for (int i=low+1; i<=low + jumpSize; i++) {
            int currentJumps = 1 + minJumps(A, i, high);
            minJumps = Math.min(minJumps, currentJumps);
        }

        return minJumps;
    }
}
