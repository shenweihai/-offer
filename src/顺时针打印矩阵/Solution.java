package 顺时针打印矩阵;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return null;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        //层数
        int levels = (Math.min(height, width) + 1) >> 1;
        for (int i = 0; i < levels; i++) {
            for (int j = i; j <= width - 1 - i; j++) {
                result.add(matrix[i][j]);
            }
            for (int k = i + 1; k <= height - 1 - i; k++) {
                result.add(matrix[k][width - 1 - i]);
            }
            //防止单行重复添加，第i层的上边界应该不等于下边界
            for (int j = width - 2 - i; j >= i && (height - 1 - i != i); j--) {
                result.add(matrix[height - 1 - i][j]);
            }
            //防止单列重复添加，第i层的左边界应该不等于右边界
            for (int k = height - 2 - i; k >= i + 1 && (width - 1 - i != i); k--) {
                result.add(matrix[k][i]);
            }
        }
        return result;
    }

}
