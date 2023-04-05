//2023-04-05
//https://school.programmers.co.kr/learn/courses/30/lessons/159993
//미로탈출

package codingtest_practice.level2;

import java.util.*;

public class MazeEscape {

    char[][] map;

    public int solution(String[] maps) {
        map = new char[maps.length][];
        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        int[] start = findXY('S');
        int[] lever = findXY('L');
        int[] exit = findXY('E');

        int sTol = shortDistance(start, lever);
        int lToe = shortDistance(lever, exit);

        if (sTol == -1 || lToe == -1) return -1;

        return sTol + lToe;
    }

    private int[] findXY(char c) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == c) return new int[] {i, j};
            }
        }
        return null;
    }

    private int shortDistance(int[] init, int[] fin) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] dp = new int[map.length][map[0].length];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Stack<int[]> stack = new Stack<>(){{push(init);}};

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int x = curr[0], y = curr[1];
            visited[x][y] = true;


            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (!checkBoundary(nx, ny)) continue;
                if (map[nx][ny] == 'X') continue;

                if (!visited[nx][ny]) {
                    stack.push(new int[] {nx, ny});
                    dp[nx][ny] = dp[x][y] + 1;
                    visited[nx][ny] = true;
                } else {
                    if (dp[nx][ny] > dp[x][y] + 1) {
                        stack.push(new int[] {nx, ny});
                        dp[nx][ny] = dp[x][y] + 1;
                    }
                }
            }
        }

        return dp[fin[0]][fin[1]] != 0 ? dp[fin[0]][fin[1]] : -1;
    }

    private boolean checkBoundary(int x, int y) {
        return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
    }
}
