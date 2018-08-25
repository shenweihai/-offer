package 把数组排成最小的数;

import java.util.*;

/**
 * 确定两数a、b的大小
 * 1. String stra = a+""+b
 * 2. String strb = b+""+a
 * 比较stra和strb大小
 * 根据这个大小将数组排序
 * 然后连成字符串
 */
public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        Collections.sort(list, (a, b) -> {
            String aStr = a + "" + b;
            String bStr = b + "" + a;
            return aStr.compareTo(bStr);
        });
        StringBuilder min = new StringBuilder();
        for (Integer integer : list) {
            min.append(integer);
        }
        return min.toString();
    }
}