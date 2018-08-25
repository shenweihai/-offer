package 字典生成算法;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 从后往前找第一个比末尾元素小的元素，下标记为i
 * 交换位置i元素和末尾元素
 * 反转i之后的元素
 *
 * 上述步骤得到当前字符串在字典的下一个
 * 循环上述步骤直到下一个等于上一个
 */
public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> rs = new ArrayList<>();
        if (str == null || str.trim().equals("")) {
            return rs;
        }
        char[] current = str.toCharArray();
        Arrays.sort(current);
        while (true) {
            rs.add(new String(current));
            char[] next = getNext(current);
            if(new String(next).equals(new String(current))){
                break;
            }
            current = next;
        }
        return rs;
    }

    public char[] getNext(char[] current) {
        char[] copy = Arrays.copyOf(current,current.length);
        for (int i = copy.length - 1; i > 0; i--) {
            if(copy[i]>copy[i-1]){
                int min = findMin(copy,copy.length-1,i,copy[i-1]);
                swap(copy,i-1,min);
                reverse(copy,i);
                break;
            }
        }
        return copy;
    }

    private void reverse(char[] current, int i) {
        int j = current.length-1;
        while(j>i){
           swap(current,i,j);
           i++;
           j--;
        }
    }

    public int findMin(char[] chars,int end ,int start,char value){
        char min = chars[start];
        int index = end;
        for (int i = end; i >= start; i--) {
            if(chars[i]<=min&&chars[i]>value){
                min= chars[i];
                index = i;
            }
        }
        return index;
    }

    public void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        ArrayList<String> abcc = new Solution().Permutation("abcc");
    }
}