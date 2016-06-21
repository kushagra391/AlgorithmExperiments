package leetcode;/* Authored by Kushagra on 2/25/2016. */

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {

        int[] A = {};
        int target = 9;
        int[] result = twoSum(A, target);
    }

    private static int[] twoSum(int[] A, int target) {

        return null;
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int x : A) set.add(target - x);
//
//        int a, b;
//        for (int x : A) {
//            if (set.contains(x)) {
//                a = x;
//                b = target - x;
//            }
//        }
//
//        int index1 = -1, index2 = -1;
//        int index = 0;
//        for (int x : A) {
//            if (x == a) index1 = index;
//            if (x == b) index2 = index;
//
//            index++;
//        }
//
//        int[] result = {index1, index2};
//        Arrays.sort(result);
//
//        return result;
    }
}
