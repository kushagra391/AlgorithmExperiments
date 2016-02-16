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

            System.out.println(countSquaresUtil(A, B));
        }
    }

    private static int countSquaresUtil(int A, int B) {

        int a = (int) Math.sqrt((double) A);
        int b = (int) Math.sqrt((double) B);

        int a1 = findNextPerfectSquare(A);
        int b1 = findPreviousPerfectSquare(B);

        int a11 = (int) Math.sqrt(a1);
        int b11 = (int) Math.sqrt(b1);

        if (a11 > b11) {
            return 0;
        }
        else
        return (b11 - a11) + 1;






    }

    private static int findNextPerfectSquare(int a) {

        int sqrt = (int) Math.sqrt(a);
        if (isPerfectSquare(a)) {
            return a;
        } else {
            return (int) Math.pow(sqrt + 1, 2);
        }
    }

    private static int findPreviousPerfectSquare(int a) {

        int sqrt = (int) Math.sqrt(a);

        return sqrt * sqrt;

    }

    private static boolean isPerfectSquare(int n) {

        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }


}
