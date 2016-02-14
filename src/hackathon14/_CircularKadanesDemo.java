package hackathon14;/* Authored by Kushagra on 2/14/2016. */

public class _CircularKadanesDemo {
    public static void main(String[] args) {

        int[] A = {11, 10, -20, 5, -3, -5, 8, -13, 10};
        System.out.println(maxCircularSum(A, A.length));
    }

    // The function returns maximum circular contiguous sum
    private static int maxCircularSum(int a[], int n) {
        // Case 1: get the maximum sum using standard kadane'
        // s algorithm
        int max_kadane = kadane(a, n);

        // Case 2: Now find the maximum sum that includes
        // corner elements.
        int max_wrap = 0, i;
        for (i = 0; i < n; i++) {
            max_wrap += a[i]; // Calculate array-sum
            a[i] = -a[i];  // invert the array (change sign)
        }

        // max sum with corner elements will be:
        // array-sum - (-max subarray sum of inverted array)
        max_wrap = max_wrap + kadane(a, n);

        // The maximum circular sum will be maximum of two sums
        return (max_wrap > max_kadane) ? max_wrap : max_kadane;
    }

    private static int kadane(int a[], int n)
    {
        int max_so_far = 0, max_ending_here = 0;
        int i;
        for (i = 0; i < n; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }

        return max_so_far;
    }

}
