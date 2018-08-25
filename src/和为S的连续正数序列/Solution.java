package 和为S的连续正数序列;

import java.util.ArrayList;

/**
 * 设序列长度为n，n< 根号2s
 * 当n为奇数时，n&1==1 && sum%n==0
 * 当n为偶数时，(sum % n)*2==n，余数为长度的1/2，证明该序列是符合条件的
 * 当满足上述其一条件时，首项=(sum / n) - (n - 1) / 2，将首项在内的n项都添加到集合
 */

/**
 * 实例化两个指针low=1,high=2分别代表左右窗口边界
 * 窗口内数列和window=((low+high)*(high-low+1))>>1
 * 当window==sum，将low到high都添加到集合，high++
 * 当window<sum，high++
 * 当window>sum,low++
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = (int) Math.sqrt(2 * sum); i >= 2; i--) {
            if ((i & 1) == 1 && sum % i == 0 || (sum % i) * 2 == i) {
                ArrayList<Integer> tmp = new ArrayList<>();
                int first = (sum / i) - (i - 1) / 2;
                for (int j = 0; j < i; j++) {
                    tmp.add(first++);
                }
                list.add(tmp);
            }
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequenceWindow(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int low = 1, high = 2;
        while (low < high) {
            int window = ((low + high) * (high - low + 1)) >> 1;
            if (window == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    tmp.add(i);
                }
                list.add(tmp);
                high++;
            } else if (window < sum) {
                high++;
            } else {
                low++;
            }
        }
        return list;
    }
}