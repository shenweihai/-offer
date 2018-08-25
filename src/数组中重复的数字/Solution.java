package 数组中重复的数字;

/**
 * 新建一个boolean数组
 * 以数组元素为下标，判断下标对应元素是否为false
 * 为false，则变为true
 * 为true，则证明已经重复，则返回该值
 */
public class Solution {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    //https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&rp=3&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tPage=1    // Return value:       true if the input is valid, and there are some duplications in the array number

    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null) return false;
        boolean array[] = new boolean[length];
        for (int number : numbers) {
            if (array[number] == false) {
                array[number] = true;
            } else {
                duplication[0] = number;
                return true;
            }
        }
        duplication[0] = -1;
        return false;
    }
}