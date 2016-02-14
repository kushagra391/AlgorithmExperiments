package hackathon14;/* Authored by Kushagra on 2/14/2016. */

public class xStringPermutationDemo {

    public static void main(String[] args) {
        String S = "ABC";
        int start = 0;
        int end = S.length();
        // permute(S, start, end - 1);


        char[] s = S.toCharArray();
        _permute(s, 0, s.length - 1);


    }

    // array based permutation
    private static void _permute(char[] s, int start, int end) {

        if (start == end) {
            System.out.println(s);
        } else {
            for (int i = start; i <= end; i++) {
                _swap(s, start, i);
                _permute(s, start + 1, end);
                _swap(s, start, i);
            }
        }
    }

    // array based swap
    private static void _swap(char[] s, int x, int y) {
        char temp = s[y];
        s[y] = s[x];
        s[x] = temp;
    }

    // string based permutation, need to return altered string each time
    private static void permute(String s, int start, int end) {
        if (start == end) {
            System.out.println(s);
        } else {
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                permute(s, start + 1, end);
                s = swap(s, start, i);
            }
        }
    }

    private static String swap(String s, int index1, int index2) {

        char[] S = s.toCharArray();

        char temp = S[index2];
        S[index2] = S[index1];
        S[index1] = temp;

        s = new String(S);
        return s;
    }
}
