package 动态规划.零一背包;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int w[] = {0, 4, 6, 2, 2, 5, 1};
        int v[] = {0, 8, 10, 6, 3, 7, 2};
        int n = 6, m = 12;
        int wv[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w[i] > j) {
                    wv[i][j] = wv[i - 1][j];
                } else {
                    wv[i][j] = Math.max(wv[i - 1][j], wv[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        for (int[] ints : wv) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }
        HashMap map = new HashMap();
        map.values();
        System.out.println("max value=" + wv[n][m]);

        int flag[] = new int[n+1];
        for (int i = n; i > 0; i--) {
            if (wv[i][m] == wv[i - 1][m]) {
                flag[i] = 0;
            } else {
                flag[i] = 1;
                m = m - w[i];
            }
        }
        for (int i : flag) {
            System.out.println(i);
        }
    }
}
