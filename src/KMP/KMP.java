package KMP;

import java.util.Arrays;

public class KMP {
    int next(char[] str, int preStart, int preEnd, int postStart, int postEnd) {
        if (preEnd < preStart) {
            return -1;
        }
        if (isEquals(str, preStart, preEnd, postStart, postEnd)) {
            return preEnd - preStart;
        } else {
            return next(str, preStart, preEnd - 1, postStart + 1, postEnd);
        }
    }

    boolean isEquals(char[] str, int preStart, int preEnd, int postStart, int postEnd) {
        if (preEnd - preStart != postEnd - postStart) {
            return false;
        }
        while (preStart <= preEnd && postStart <= postEnd) {
            if (str[preStart++] != str[postStart++]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "ababaca";
        KMP kmp = new KMP();
        char[] a = str.toCharArray();
        int[] next = new int[a.length];
        next[0] = -1;
        for (int i = 1; i < a.length; i++) {
            next[i] = kmp.next(a, 0, i - 1, 1, i);
        }
        System.out.println(Arrays.toString(next));
    }
}
