package hackathon14;/* Authored by Kushagra on 2/14/2016. */

import java.util.Arrays;

public class RotateArrayDemo {

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5, 6};
        int d = 2;

        leftRotate(A, d);
        System.out.println(Arrays.toString(A));

    }

    private static void leftRotate(int[] A, int d) {

        int n = A.length;

        reverseArray(A, 0, n - 1);          // rotate the whole array
        reverseArray(A, 0, n - d - 1);      // rotate second part
        reverseArray(A, n - d, n - 1);      // rotate first part

    }

    private static void reverseArray(int[] A, int left, int right) {

        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;

            left++;
            right--;
        }

    }

}
