package 动态规划.硬币问题;

public class Solution {
    private int[] coin = {1,3,5};

    public int minCoinNum(int total){
        int sum[] = new int[total+1];
        sum[0] = 0;
        for (int i = 1; i <= total; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coin.length; j++) {
                if(i>=coin[j]&&min>sum[i-coin[j]]+1){
                    min = sum[i-coin[j]]+1;
                }
            }
            sum[i] = min;
        }
        for (int i : sum) {
            System.out.println(i);
        }
        return sum[total];
    }

    public static void main(String s[]){
        new Solution().minCoinNum(11);
    }
}
