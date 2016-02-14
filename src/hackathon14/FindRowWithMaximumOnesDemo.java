package hackathon14;/* Authored by Kushagra on 2/14/2016. */

public class FindRowWithMaximumOnesDemo {
    public static void main(String[] args) {
        int[][] M = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        System.out.println("Max Row: " + findRowWithMaxOnes(M));

        int[] A = {0, 0, 0, 1, 1, 1};
        findIndexOne(A, 0, A.length - 1);
    }

    private static int findRowWithMaxOnes(int[][] M) {

        int rows = M.length;
        int cols = M[0].length;

        int minIndex = Integer.MAX_VALUE;
        int index;
        int maxRow = -1;
        for (int row = 0; row < rows; row++) {
            index = findIndexOne(M[row], 0, cols - 1);
            if (index < minIndex) {
                maxRow = row;
            }
        }

        return maxRow;
    }

    // finds the first occurrence of 1
    private static int findIndexOne(int[] A, int low, int high) {
        if (low > high) {
            return Integer.MAX_VALUE;
        }

        // Important Base condition
        int mid = (low + high) / 2;
        if (mid == 0 || A[mid] == 1 && A[mid - 1] == 0) {
            return mid;
        }

        // Recurrence
        if (A[mid] == 0) {
            low = mid + 1;
            return findIndexOne(A, low, high);
        } else {
            high = mid;
            return findIndexOne(A, low, high);
        }
    }
}
