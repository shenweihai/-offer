package 第一个只出现一次的字符;

/**
 * 以下标转换到另一个数组，计算count
 * 遍历count数组，为1则return
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0){
            return -1;
        }
        char[] array = str.toCharArray();
        int[] count = new int[123];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        for (int i = 0; i < array.length; i++) {
            if(count[array[i]]==1){
                return i;
            }
        }
        return -1;
    }
}