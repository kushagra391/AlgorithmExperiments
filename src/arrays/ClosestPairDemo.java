package arrays;/* Authored by Kushagra on 2/8/2016. */

public class ClosestPairDemo {

    public static void main(String[] args) {

        int[] A = {0, 22, 28, 29, 30, 40};
        int x = 54;
        System.out.println(closestPair(A, x));
    }

    private static Pair closestPair(int[] A, int x) {

        int n = A.length;

        int left = 0;
        int right = n - 1;

        int diff = Integer.MAX_VALUE;

        Pair result = new Pair();
        while (left < right) {
            int leftElement = A[left];
            int rightElement = A[right];
            int sum = leftElement + rightElement;

            if (diff > Math.abs(sum - x)) {
                diff = Math.abs(sum - x);
                result.setValues(leftElement, rightElement);
            }

            if (sum > x) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }


    private static class Pair {
        int firstElement;
        int secondElement;

        Pair() {
            this.firstElement = -1;
            this.secondElement = -1;
        }

        Pair(int x, int y) {
            this.firstElement = x;
            this.secondElement = y;
        }

        public void setValues(int x, int y) {
            this.firstElement = x;
            this.secondElement = y;
        }

        public String toString() {
            return String.format("The closest pair is %d andcd  %d", this.firstElement, this.secondElement);
        }
    }
}
