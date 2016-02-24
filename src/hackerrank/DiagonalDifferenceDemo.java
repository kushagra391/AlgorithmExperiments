package hackerrank;/* Authored by Kushagra on 2/24/2016. */

import java.util.Scanner;

public class DiagonalDifferenceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] A = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        printDiagonalDiff(A, n);
    }

    private static void printDiagonalDiff(int[][] A, int n) {

        int sum1 = 0;
        for (int i=0; i<n; i++) {
            sum1 += A[i][i];
        }

        int row = 0;
        int sum2 = 0;
        for (int col = n-1; col>=0; col--) {
            sum2 += A[row++][col];
        }

        int diff = Math.abs(sum1 - sum2);

        System.out.println(diff);
    }
}
