package strings;/* Authored by Kushagra on 2/11/2016. */

import java.util.HashMap;

public class FindAllPairAnagrams {

    public static void main(String[] args) {

        String[] list = {};
        printAllPairs(list);
    }

    private static void printAllPairs(String[] strings) {

        int n = strings.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = strings[i];
                String s2 = strings[j];
                if (isAnagram(s1, s2))
                    System.out.println(s1 + ", " + s2);
            }
        }
    }

    private static boolean isAnagram(String s1, String s2) {

        HashMap<Character, Integer> countMap = new HashMap<>();

        for (char x : s1.toCharArray()) {
            if (countMap.containsKey(x)) {
                int count = countMap.get(x);
                countMap.put(x, count + 1);
            } else {
                countMap.put(x, 1);
            }
        }


        for (char x : s2.toCharArray()) {
            if (countMap.containsKey(x)) {
                int count = countMap.get(x);
                countMap.put(x, count - 1);
            } else {
                return false;
            }

        }

        for (int count : countMap.values()) {
            if (count != 0)
                return false;
        }

        return true;
    }


}
