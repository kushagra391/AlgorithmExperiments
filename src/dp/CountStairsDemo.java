package dp;/* Authored by Kushagra on 2/11/2016. */

public class CountStairsDemo {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(findCountOfWays(n));

        // also solve the generic case, with w max jumps allowed
    }

    private static int findCountOfWays(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        return findCountOfWays(n-1) + findCountOfWays(n-2);
    }
}
