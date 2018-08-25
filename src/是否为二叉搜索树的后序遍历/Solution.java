package 是否为二叉搜索树的后序遍历;

/**
 * 后序遍历根节点在最后一位，且右子树的所有元素都大于左子树
 *
 * 1.找到第一个大于根节点的点，根据该点将数组分为两个部分
 * 2.判断是不是左子树全小于根节点，右子树是不是都大于根节点
 */

/**
 * 递归
 * 通过根节点将数组分为左子树和右子树
 * 递归的判断左子树和右子树是否二叉搜索树的后序遍历
 * 判断过程
 * 1.找到第一个大于根节点的点
 * 2.判断后续的节点是否全大于根节点，不是则return false
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int length = sequence.length;
        while (--length != 0) {
            int i = 0;
            while (i <= length && sequence[i++] < sequence[length]) ;
            while (i <= length && sequence[i++] > sequence[length]) ;
            if (i < length) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().VerifySquenceOfBST(new int[]{1, 2, 3, 4, 5});
    }
    /*public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        if(sequence.length==1){
            return true;
        }
        return verify(sequence,0,sequence.length-1);
    }*/

    public boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) return false;
        }
        return verify(sequence, start, i - 1) && verify(sequence, i, end - 1);
    }


}