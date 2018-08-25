package 迪杰斯特拉;

import java.util.Arrays;

public class Dijkstra {
    /**
     * 邻接矩阵
     */
    private static int[][] matrix;
    /**
     * 表示正无穷
     */
    private static int MAX_WEIGHT = Integer.MAX_VALUE;
    /**
     * 顶点集合
     */
    private static String[] vertexes;

    /**
     * 创建图2
     */
    private void createGraph2(int index) {
        matrix = new int[index][index];
        vertexes = new String[index];

        int[] v0 = {0, 1, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] v1 = {1, 0, 3, 7, 5, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] v2 = {5, 3, 0, MAX_WEIGHT, 1, 7, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] v3 = {MAX_WEIGHT, 7, MAX_WEIGHT, 0, 2, MAX_WEIGHT, 3, MAX_WEIGHT, MAX_WEIGHT};
        int[] v4 = {MAX_WEIGHT, 5, 1, 2, 0, 3, 6, 9, MAX_WEIGHT};
        int[] v5 = {MAX_WEIGHT, MAX_WEIGHT, 7, MAX_WEIGHT, 3, 0, MAX_WEIGHT, 5, MAX_WEIGHT};
        int[] v6 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 3, 6, MAX_WEIGHT, 0, 2, 7};
        int[] v7 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 9, 5, 2, 0, 4};
        int[] v8 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 7, 4, 0};
        matrix[0] = v0;
        matrix[1] = v1;
        matrix[2] = v2;
        matrix[3] = v3;
        matrix[4] = v4;
        matrix[5] = v5;
        matrix[6] = v6;
        matrix[7] = v7;
        matrix[8] = v8;

        vertexes[0] = "v0";
        vertexes[1] = "v1";
        vertexes[2] = "v2";
        vertexes[3] = "v3";
        vertexes[4] = "v4";
        vertexes[5] = "v5";
        vertexes[6] = "v6";
        vertexes[7] = "v7";
        vertexes[8] = "v8";
    }

    /**
     * 创建图1
     */
    private void createGraph1(int index) {
        matrix = new int[index][index];
        vertexes = new String[index];

        int[] v0 = {0, 1, MAX_WEIGHT, MAX_WEIGHT, 2, MAX_WEIGHT};
        int[] v1 = {1, 0, 1, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] v2 = {MAX_WEIGHT, 1, 0, 1, MAX_WEIGHT, MAX_WEIGHT};
        int[] v3 = {MAX_WEIGHT, MAX_WEIGHT, 1, 0, 1, MAX_WEIGHT};
        int[] v4 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 1, 0, 1};
        int[] v5 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 1, 1, 0};

        matrix[0] = v0;
        matrix[1] = v1;
        matrix[2] = v2;
        matrix[3] = v3;
        matrix[4] = v4;
        matrix[5] = v5;

        vertexes[0] = "A";
        vertexes[1] = "B";
        vertexes[2] = "C";
        vertexes[3] = "D";
        vertexes[4] = "E";
        vertexes[5] = "F";
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        int length = 9;
        //dijkstra.createGraph1(length);
        dijkstra.createGraph2(length);
        boolean visit[] = new boolean[length];
        int start = 0;
        visit[start] = true;
        int[] min = Arrays.copyOf(matrix[start], length);
        for (int i = 1; i < length; i++) {
            int minIndex = min(min, visit);
            visit[minIndex] = true;
            for (int j = 0; j < min.length; j++) {
                if (((long) min[minIndex] + matrix[minIndex][j]) < min[j]) {
                    min[j] = min[minIndex] + matrix[minIndex][j];
                }
            }
        }
        System.out.println(Arrays.toString(min));
    }

    private static int min(int[] min, boolean[] visit) {
        int minValue = Integer.MAX_VALUE;
        int k = -1;
        for (int i = 0; i < min.length; i++) {
            if (!visit[i] && min[i] < minValue) {
                minValue = min[i];
                k = i;
            }
        }
        return k;
    }
}
