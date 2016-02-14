package hackathon14;/* Authored by Kushagra on 2/14/2016. */

public class xStringPermutationDemo {

    public static void main(String[] args) {
        String S = "ABC";
        int start = 0;
        int end = S.length();
        permute(S, start, end);
    }

    private static void permute(String s, int start, int end) {
        if (start == end) {
            System.out.println(s);
        } else {
            for (int i = start; i < end - 1; i++) {
                swap(s, start + 1, i);
                permute(s, i + 1, end);
                swap(s, i, start + 1);
            }
        }
    }

    private static void swap(String s, int index1, int index2) {

        char[] S = s.toCharArray();

        char temp = S[index2];
        S[index2] = S[index1];
        S[index1] = temp;

        s = new String(S);
    }

}
