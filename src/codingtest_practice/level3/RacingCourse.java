//2023-09-23
//https://school.programmers.co.kr/learn/courses/30/lessons/67259#
//경주로 건설

package codingtest_practice.level3;

public class RacingCourse {

    private int[][] map;
    private int[][] dp;
    private int[][] dirs;

    public int solution(int[][] board) {
        map = board;

        dp = new int[board.length][board[0].length];
        dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        dfs(new int[] {0, 0}, new int[] {1, 1}, 0, 0);
        int d1 = dp[board.length - 1][board[0].length - 1];


        dp = new int[board.length][board[0].length];
        dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        dfs(new int[] {0, 0}, new int[] {1, 1}, 0, 0);
        int d2 = dp[board.length - 1][board[0].length - 1];


        return Math.min(d1, d2);
    }

    private void dfs(int[] currPos, int[] dir, int straight, int corner) {
        if (currPos[0] == map.length - 1 && currPos[1] == map[0].length - 1) {
            updateDP(currPos, straight, corner);
            return;
        }
        int y = currPos[0];
        int x = currPos[1];

        for (int[] d : dirs) {
            int[] temp = {y + d[0], x + d[1]};
            if (!boundary(temp)) continue;
            if (map[temp[0]][temp[1]] == 1) continue;

            int s = straight + 1;
            int c = corner;

            if (isCorner(dir, d)) c += 1;
            if (updateDP(temp, s, c)) dfs(temp, d, s, c);

        }
    }

    private boolean updateDP(int[] curr, int straight, int corner) {
        int cost = getCost(straight, corner);

        if (dp[curr[0]][curr[1]] == 0) {
            dp[curr[0]][curr[1]] = cost;
            return true;
        }
        if (dp[curr[0]][curr[1]] >= cost) {
            dp[curr[0]][curr[1]] = cost;
            return true;
        }
        return false;
    }

    private int getCost(int straight, int corner) {
        return 100 * straight + 500 * corner;
    }

    private boolean boundary(int[] pos) {
        return 0 <= pos[0] && pos[0] < map.length &&
                0 <= pos[1] && pos[1] < map[0].length;
    }

    private boolean isCorner(int[] d1, int[] d2) {
        return d1[0] == 0 && d2[1] == 0 ||
                d1[1] == 0 && d2[0] == 0;
    }
}
