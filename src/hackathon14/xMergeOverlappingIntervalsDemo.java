package hackathon14;/* Authored by Kushagra on 2/14/2016. */

import java.util.*;

public class xMergeOverlappingIntervalsDemo {

    public static void main(String[] args) {

        Interval i1 = new Interval(1, 4);
        Interval i2 = new Interval(2, 5);
        Interval i3 = new Interval(6, 8);
        Interval i4 = new Interval(9, 11);
        Interval i5 = new Interval(10, 12);

        Interval[] intervals = {i1, i2, i3, i4, i5};
        List<Interval> mergedIntervals = mergeIntervals(intervals);
        System.out.println(mergedIntervals.toString());
    }

    private static List<Interval> mergeIntervals(Interval[] intervals) {

        Arrays.sort(intervals, new IntervalComparator());

        List<Interval> result = new ArrayList<>();

        Interval prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            Interval curr = intervals[i];

            if (canBeMerged(prev, curr)) {
                prev = new Interval(prev.start, curr.end);
                result.add(prev);
            } else {
                result.add(curr);
            }

            prev = curr;
        }

        result.add(prev);

        return result;
    }

    private static boolean canBeMerged(Interval prev, Interval curr) {

        return (prev.end > curr.start);
    }


    static class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }


    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
