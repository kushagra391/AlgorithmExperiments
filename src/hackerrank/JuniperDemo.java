package hackerrank;/* Authored by Kushagra on 2/24/2016. */

import java.util.Arrays;
import java.util.Scanner;

public class JuniperDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        int n = sc.nextInt();

        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

//        System.out.println(V);
//        System.out.println(Arrays.toString(A));


        binarySearch(A, V);

    }

    private static void binarySearch(int[] A, int V) {

        int lo = 0;
        int hi = A.length - 1;

        int mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (A[mid] == V) {
                System.out.println(mid);
                break;
            }

            if (A[mid] < V) {
                lo = mid + 1;
            }
            else { // search right
                hi = mid - 1;
            }
        }
    }


}
