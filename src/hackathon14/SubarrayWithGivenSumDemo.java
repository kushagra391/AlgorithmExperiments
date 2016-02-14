package hackathon14;/* Authored by Kushagra on 2/14/2016. */

import java.util.ArrayList;
import java.util.List;

public class SubarrayWithGivenSumDemo {
    public static void main(String[] args) {
        int[] A = {5, 4, 13, 11, 2, 9};
        int S = 28;

        List<Integer> result = findSubarrayWithSum(A, S);
        System.out.println(result.toString());
    }

    private static List<Integer> findSubarrayWithSum(int[] A, int S) {

        List<Integer> result = new ArrayList<>();

        int n = A.length;

        int left = 0;
        int right = 0;

        int currentSum = 0;
        while (currentSum <= S) {
            currentSum =+ A[right];
            right ++;
        }

        while (right < n) {

            if (currentSum < S) {

            }



        }




        return result;
    }
}
