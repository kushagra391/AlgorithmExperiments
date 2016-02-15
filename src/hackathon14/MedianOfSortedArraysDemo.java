package hackathon14;/* Authored by Kushagra on 2/14/2016. */

public class MedianOfSortedArraysDemo {

    public static void main(String[] args) {
        int[] A = {1, 12, 15, 26, 38};
        int[] B = {2, 13, 17, 30, 45};

        System.out.println(findMedian(A, B));
        System.out.println(findMedian1(A, B));

    }

    private static int findMedian(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;

        if (m == 0 && n == 0) return -1;
        if (m == 0 && n > 0) return median(B);
        if (m > 0 && n == 0) return median(A);

        else
            return findMedianOfSortedArrays(A, B, n);
    }

    private static int findMedianOfSortedArrays(int[] A, int[] B, int n) {

        // Base Conditions
        if (n == 0) return -1;
        if (n == 1) return (A[0] + B[0]) / 2;
        if (n == 2)
            return (Math.max(A[0], B[0]) + Math.min(A[1], B[1])) / 2;

        // Recurrence
        return 0;






    }

    private static int median(int[] A) {

        int n = A.length;

        if (n % 2 == 0) {
            int m1 = A[n / 2];
            int m2 = A[n / 2 - 1];
            return (m1 + m2) / 2;
        } else {
            return A[n / 2];
        }
    }

    // 2n elements
    // median = (m1 + m2) / 2
    // m1 = index n
    // m2 = index n + 1
    private static int findMedian1(int[] A1, int[] A2) {

        int n = A1.length;
        int m1 = -1;
        int m2 = -1;

        int i = 0;      // index for A1
        int j = 0;      // index for A2

        for (int count = 0; count <= n; count++) {

            // all elements from A1
            if (i == n) {
                m1 = m2;
                m2 = A2[0];

                break;
            }

            // all element from A2
            else if (j == n) {
                m1 = m2;
                m2 = A1[0];

                break;
            }

            // usual merge
            else {

                if (A1[i] < A2[j]) {
                    m1 = m2;
                    m2 = A1[i];
                    i++;
                } else {
                    m1 = m2;
                    m2 = A2[j];
                    j++;
                }
            }
        }

        return (m1 + m2) / 2;
    }


}
