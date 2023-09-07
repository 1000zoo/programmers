//2023-09-08
//https://school.programmers.co.kr/learn/courses/30/lessons/169199
//리코쳇 로봇

package codingtest_practice.level2;

import java.util.*;

public class RicochetRobot {

    private char[][] map;

    public int solution(String[] board) {
        int[][] info = setMap(board);
        int[][] dp = new int[map.length][map[0].length];
        int[] start = info[0];
        int[] goal = info[1];

        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int[] next;
            int nextDistance = dp[curr[0]][curr[1]] + 1;

            for (int i = 0; i < 4; i++) {
                next = moveUntilWall(curr, getDirection(i));
                if (dp[next[0]][next[1]] == 0 ||
                        dp[next[0]][next[1]] > nextDistance) {
                    dp[next[0]][next[1]] = nextDistance;
                    q.add(next);
                }
            }
        }

        if (dp[goal[0]][goal[1]] == 0) return -1;
        return dp[goal[0]][goal[1]];
    }

    private int[] moveUntilWall(int[] pos, int[] dir) {
        int[] next = move(pos, dir);

        while (!equals(pos, next)) {
            pos = Arrays.copyOf(next, next.length);
            next = move(pos, dir);
        }

        return pos;
    }

    private int[] move(int[] pos, int[] dir) {
        int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
        return cantMove(next) ? pos : next;
    }

    private int[] getDirection(int m) {
        return m == 0 ? new int[] {0, 1} :
                m == 1 ? new int[]{0, -1} :
                        m == 2 ? new int[] {1, 0} :
                                m == 3 ? new int[] {-1, 0} :
                                        new int[] {};
    }

    private boolean cantMove(int[] pos) {
        if (!(0 <= pos[0] && pos[0] < map.length &&
                0 <= pos[1] && pos[1] < map[0].length)) return true;
        return map[pos[0]][pos[1]] == 'D';
    }

    private boolean equals(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    private int[][] setMap(String[] board) {
        map = new char[board.length][];
        int[][] info = new int[2][];

        for (int i = 0; i < map.length; i++) {
            map[i] = board[i].toCharArray();
            int g = board[i].indexOf('G');
            int s = board[i].indexOf('R');
            if (s != -1) {
                info[0] = new int[] {i, s};
            }
            if (g != -1) {
                info[1] = new int[] {i, g};
            }
        }

        return info;
    }
}
