//2023-08-03
//https://school.programmers.co.kr/learn/courses/30/lessons/77485#
//행렬 테두리 회전하기

package codingtest_practice.level2;

import java.util.*;

public class MatrixRotate {
    private List<Integer> list;
    private int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int dirIndex = 0;

    public int[] solution(int rows, int columns, int[][] queries) {
        list = new ArrayList<>();
        int[][] mat = new int[rows + 1][columns + 1];
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                mat[i][j] = num++;
            }
        }

        for (int[] q : queries) {
            rotate(mat, q);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private void rotate(int[][] matrix, int[] query) {
        int prev = matrix[query[0]][query[1]];
        int min = prev;
        int[] start = new int[] {query[0], query[1]};
        int[] curr = getNext(new int[] {query[0], query[1]}, query);


        while (curr[0] != start[0] || curr[1] != query[1]) {
            int r = curr[0];
            int c = curr[1];
            min = Math.min(min, prev);

            int temp = prev;
            prev = matrix[r][c];
            matrix[r][c] = temp;
            curr = getNext(curr, query);
        }
        matrix[start[0]][start[1]] = prev;
        min = Math.min(min, prev);


        list.add(min);
    }

    private int[] getNext(int[] curr, int[] query) {
        int[] next = new int[] {curr[0] + directions[dirIndex][0], curr[1] + directions[dirIndex][1]};
        if (!isWithinBoundary(next, query)) {
            dirIndex += 1;
            dirIndex %= 4;
            next = new int[] {curr[0] + directions[dirIndex][0], curr[1] + directions[dirIndex][1]};
        }
        return next;
    }

    private boolean isWithinBoundary(int[] curr, int[] query) {
        return query[0] <= curr[0] && curr[0] <= query[2] &&
                query[1] <= curr[1] && curr[1] <= query[3];
    }
}
