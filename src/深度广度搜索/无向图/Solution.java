package 深度广度搜索.无向图;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        char vertex[] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        boolean visit[] = new boolean[7];
        int matrix[][] = new int[7][7];
        matrix[0][2] = 1;
        matrix[0][3] = 1;
        matrix[0][5] = 1;
        matrix[1][2] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][3] = 1;
        matrix[3][0] = 1;
        matrix[3][2] = 1;
        matrix[4][6] = 1;
        matrix[5][0] = 1;
        matrix[5][6] = 1;
        matrix[6][4] = 1;
        matrix[6][5] = 1;
        new Solution().DFS(0, matrix, vertex, visit);
        System.out.println();
        new Solution().BFS(vertex, matrix);
    }

    void DFS(int i, int[][] matrix, char[] vertex, boolean[] visit) {
        System.out.print(vertex[i] + " ");
        visit[i] = true;
        for (int j = 0; j < matrix[i].length; j++) {
            if (i != j && matrix[i][j] == 1 && !visit[j]) {
                DFS(j, matrix, vertex, visit);
            }
        }
    }

    void BFS(char[] vertex, int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        list.add(0);
        boolean[] visit = new boolean[7];
        visit[0] = true;
        BFS(list, index, matrix, visit, vertex);
    }

    void BFS(List<Integer> list, int index, int[][] matrix, boolean[] visit, char[] vertex) {
        while (list.size() > index) {
            int i = list.get(index);
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != j && matrix[i][j] == 1 && !visit[j]) {
                    list.add(j);
                    visit[j] = true;
                }
            }
            index++;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(vertex[list.get(i)] + " ");
        }
    }
}
