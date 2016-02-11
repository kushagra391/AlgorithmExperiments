package dp;/* Authored by Kushagra on 2/10/2016. */

public class PartitionDemo {

    public static void main(String[] args) {
        int[] A = {};
        System.out.println(findPartition(A));
    }

    private static boolean findPartition(int[] A) {

        int sum = 0;
        for (int x : A) {
            sum =+ x;
        }

        sum = sum / 2;

        return SubsetSumDemo.SubsetSum(A, A.length, sum);
    }

}
