package 扑克牌顺子;

/**
 * 满足两个条件：
 * 1.max-min<5
 * 2.除了0，其他元素不重复
 * 用bitmap位图保存出现过的元素
 * 判断是否出现过（bitmap右移number位，看是否&1==1，=1代表出现过，return false）
 * 没出现则flag |= 1左移number位
 */

/**
 * 先排序
 * 判断是否重复，判断是否超过范围
 * 计算0的数量count0
 * 计算相邻元素的差值-1的和count1
 * 如果count0==count1，则return true
 */
public class Solution {
    /*public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int count0 = 0;//0的个数
        int count1 = 0;//非0数之间的间隔值，2、5之间差3、4两个数
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                count0++;
            } else {
                if (numbers[i] == numbers[i + 1]) {
                    return false;
                }
                count1 += numbers[i + 1] - numbers[i] - 1;
            }
        }
        if (count0 >= count1) {
            return true;
        } else return false;
    }*/
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int min = 14;
        int max = -1;
        int bitmap = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number > 13 || number < 0) {
                return false;
            }
            if (number == 0) {
                continue;
            }
            if (((bitmap >> number) & 1) == 1) {
                return false;
            }
            bitmap |= (1 << number);
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            if (max - min >= 5) {
                return false;
            }
        }
        return true;
    }
}