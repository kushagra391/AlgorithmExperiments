package hackerrank;/* Authored by Kushagra on 2/24/2016. */

import java.util.Scanner;

public class LonelyIntegerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i=0; i<n; i++) {
            A[i] = sc.nextInt();
        }

        printLonelyInteger(A);
    }

    private static void printLonelyInteger(int[] A) {
        int n = A.length;

        int xor = 0;
        for (int aA : A) {
            xor = xor ^ aA;
        }

        System.out.println(xor);
    }
}
