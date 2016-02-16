package indeed;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine());
        String[] _arr = new String[_arr_size];
        String _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            try {
                _arr_item = in.nextLine();
            } catch (Exception e) {
                _arr_item = null;
            }
            _arr[_arr_i] = _arr_item;
        }

        countSquares(_arr);
    }

    private static void countSquares(String[] arr) {

        for (String line : arr) {
            String[] ranges = line.split(" ");
            int A = Integer.parseInt(ranges[0]);
            int B = Integer.parseInt(ranges[1]);

            System.out.println(countSquaresHelper(A, B));
        }
    }

    private static int countSquaresHelper(int A, int B) {

        int a = (int) Math.sqrt((double) A);
        int b = (int) Math.sqrt((double) B);

        int nextPerfectSquareA = nextPerfectSquare(A);
        int nextPerfectSquareB = previousPerfectSquare(B);

        int sqrtRootOfNextA = (int) Math.sqrt(nextPerfectSquareA);
        int sqrtRootOfNextB = (int) Math.sqrt(nextPerfectSquareB);

        if (sqrtRootOfNextA > sqrtRootOfNextB) {
            return 0;
        }
        else
        return (sqrtRootOfNextB - sqrtRootOfNextA) + 1;
    }

    private static int nextPerfectSquare(int number) {

        int sqrt = (int) Math.sqrt(number);
        if (isPerfectSquare(number)) {
            return number;
        } else {
            return (int) Math.pow(sqrt + 1, 2);
        }
    }

    private static int previousPerfectSquare(int number) {

        int sqrt = (int) Math.sqrt(number);

        return sqrt * sqrt;

    }

    private static boolean isPerfectSquare(int n) {

        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }


}
