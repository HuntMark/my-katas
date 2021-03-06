package my.rinat.codewars.reversedsequence;

public class Sequence {
    public static int[] reverse(int n) {
        int[] result = new int[n];
        for (int i = n, j = 0; i >= 1 || j < 5; i--, j++) {
            result[j] = i;
        }
        return result;
    }
}