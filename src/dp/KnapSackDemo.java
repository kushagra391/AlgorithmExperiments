package dp;/* Authored by Kushagra on 2/11/2016. */

public class KnapSackDemo {

    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        int n = values.length;
        System.out.println(knapSack(values, weights, W, n));
    }

    private static int knapSack(int[] values, int[] weights, int W, int n) {
        // Base case
        if (n == 0) return 0;
        if (W == 0) return 0;

        if (weights[n-1] > W)
            return knapSack(values, weights, W, n-1);

        else return Math.max(
                knapSack(values, weights, W, n-1),                              // current item is not selected
                values[n-1] + knapSack(values, weights, W-weights[n-1], n-1)    // current item is selected
        );
    }
}
