package leetcode;

import java.util.*;

/**
 * Created by kushagra on 6/20/16.
 */
public class ArrayIntersectionDemo {

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 1, 1};
        int[] B = {3, 1, 1};

        int[] result1 = intersection1(A, B);
        int[] result2 = intersection2(A, B);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    private static int[] intersection2(int[] A, int[] B) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        buildMap(A, map1);
        buildMap(B, map2);


        List<Integer> list = new ArrayList<>();

        for (int x : map1.keySet()) {

            if (map2.containsKey(x)) {
                int count = Math.min(map1.get(x), map2.get(x));
                for (int i=0; i<count; i++) {
                    list.add(x);
                }
            }
        }

        int index = 0;
        int[] result = new int[list.size()];
        for (int x : list) {
            result[index++] = x;
        }

        return result;
   }

    private static void buildMap(int[] A, Map<Integer, Integer> map1) {
        for (int a : A) {
            if (map1.containsKey(a)) {
                int count = map1.get(a);
                map1.put(a, count + 1);
            }
            else {
                map1.put(a, 1);
            }
        }
    }

    private static int[] intersection1(int[] A, int[] B) {

        HashSet<Integer> set = new HashSet<>();

        HashSet<Integer> result = new HashSet<>();

        for (int x : A ) {
            set.add(x);
        }

        for (int y : B) {
            if (set.contains(y)) {
                result.add(y);
            }
        }

        int index = 0;
        int[] R = new int[result.size()];
        for (int z : result) {
            R[index++] = z;
        }

        return R;
    }
}
