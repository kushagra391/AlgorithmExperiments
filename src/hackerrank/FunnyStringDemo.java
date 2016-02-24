package hackerrank;/* Authored by Kushagra on 2/24/2016. */

import java.util.Scanner;

public class FunnyStringDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            StringBuilder s = new StringBuilder(sc.next());
            isFunny(s);
        }

    }

    private static void isFunny(StringBuilder S) {

        StringBuilder R = new StringBuilder(S).reverse();
        int n = S.length();
        int diff1;
        int diff2;
        for (int i=1; i<n; i++) {

            diff1 = Math.abs(S.charAt(i) - S.charAt(i-1));
            diff2 = Math.abs(R.charAt(i) - R.charAt(i-1));

            if (diff1 != diff2) {
                System.out.println("Not Funny");
                return;
            }
        }

        System.out.println("Funny");
    }
}
