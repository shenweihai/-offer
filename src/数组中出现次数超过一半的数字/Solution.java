package 数组中出现次数超过一半的数字;

/**
 * 士兵同归于尽，遇见不相同的就同归于尽
 * 初始化value=array[0](上一个士兵),count=1(当前士兵剩余数量)
 * 1.上一个士兵不等于当前士兵，count--
 * 2.上一个士兵等于当前士兵，count++
 * 3.count是否为0，为0则重新赋值，value=array[i],count=1
 * 遍历完后得到value，value是唯一有可能超过一半的
 * 遍历数组，通过value出现的次数，看是否超过一半
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int count = 1;
        int value = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                value = array[i];
                count = 1;
            } else if (value == array[i]) {
                count++;
            } else if (value != array[i]) {
                count--;
            }
        }
        count = 0;
        for (int i : array) {
            if (i == value) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return value;
        } else {
            return 0;
        }
    }

    public static void main(String s[]) {
        int value = new Solution().MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(value);
    }
}
