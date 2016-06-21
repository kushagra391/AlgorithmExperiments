package leetcode;

/**
 * Created by kushagra on 6/20/16.
 */
public class IsUglyDemo {

    public static void main(String[] args) {

        int n = 14;

        System.out.println(isUgly(n));

    }

    private static boolean isUgly(int n) {

        n = residual(n, 2);
        n = residual(n, 3);
        n = residual(n, 5);

        return (n == 1);
    }

    private static int residual(int n, int x) {

        int res = n;

        while (res % x == 0) {
            res = res / x;
        }

        return res;
    }
}
