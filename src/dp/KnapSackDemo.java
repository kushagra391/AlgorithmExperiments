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

        if (weights[n - 1] > W)
            return knapSack(values, weights, W, n - 1);

        else return Math.max(
                knapSack(values, weights, W, n - 1),                              // current item is not selected
                values[n - 1] + knapSack(values, weights, W - weights[n - 1], n - 1)    // current item is selected
        );
    }

    private static int knapsack(int[] values, int[] weights, int W, int n) {

        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = 0; w < W; w++) {

                if (i == 0 || w == 0) K[i][w] = 0; // Base case
                if (weights[w - 1] > w)
                    K[i][w] = K[i - 1][w];
                else
                    K[i][w] = Math.max(K[i - 1][w], values[i - 1] + K[i - 1][w - weights[i - 1]]);
            }
        }

        return K[n][W];
    }
}
