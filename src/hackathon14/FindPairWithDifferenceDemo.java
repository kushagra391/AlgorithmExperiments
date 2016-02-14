package hackathon14;/* Authored by Kushagra on 2/14/2016. */

import java.util.HashSet;

public class FindPairWithDifferenceDemo {
    public static void main(String[] args) {
        int[] A = {5, 4, 13, 11, 2, 9};
        int k = 3;

        findPair(A, k);
    }

    private static void findPair(int[] A, int k) {

        HashSet<Integer> set = new HashSet<>();
        for (int x : A) {
            set.add(x);
        }

        for (int x : A) {
            int y = x + k;
            if (set.contains(y)) {
                System.out.println(y);
                System.out.println(y - k);
            }
        }
    }
}
