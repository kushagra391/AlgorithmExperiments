package hackathon14;/* Authored by Kushagra on 2/14/2016. */

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SortNearlySortedArrayDemo {
    public static void main(String[] args) {
        int[] A = {2, 6, 3, 12, 56, 8};
        int k = 3;
        sortNearlySortedArray(A, k);
        System.out.println(Arrays.toString(A));


        // heap review
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(2);
        maxHeap.add(21);
        maxHeap.add(12);
        maxHeap.add(11);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.size());
    }

    private static void sortNearlySortedArray(int[] A, int k) {

        int n = A.length;
        if (n < k) {
            Arrays.sort(A);
            return;
        }

        // create a maxHeap of size k
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int i=0; i<k; i++) {
            maxHeap.add(A[i]);
        }

        // iterate from index k to the end
        int sortedIndex = 0;
        for (int i=k; i<n; i++) {
            // keep popping out the root node
            A[sortedIndex++] = maxHeap.poll();
            maxHeap.add(A[i]);
        }

        // pop out the remaining items
        while (!maxHeap.isEmpty()) {
            A[sortedIndex++] = maxHeap.poll();
        }

        // array is now completely sorted
    }
}
