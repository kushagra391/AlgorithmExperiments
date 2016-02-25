package hackerrank;/* Authored by Kushagra on 2/24/2016. */

import java.util.HashMap;
import java.util.Scanner;

public class GameOfThronesOne {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        isPalindromic(s);
    }

    @SuppressWarnings("Duplicates")
    private static void isPalindromic(String S) {
        int n = S.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : S.toCharArray()) {

            if (map.containsKey(x)) {
                int count = map.get(x);
                map.put(x, count + 1);
            } else {
                map.put(x, 1);
            }
        }

        int oddCount = 0;
        for (char x : map.keySet()) {
            int count = map.get(x);
            if (isOdd(count)) {
                oddCount++;
            }
        }

        if (isOdd(n)) {
            if (oddCount == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        else {
            if (oddCount == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static boolean isOdd(int count) {
        return (count % 2 == 1);
    }
}
