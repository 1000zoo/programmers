package codingtest_practice.level3;

public class RacingCourse {

    private int[][] map;

    public int solution(int[][] board) {
        map = board;
        boolean[][] visited = new boolean[map.length][map[0].length];
        return dfs(new int[] {0, 0}, new int[] {1, 1}, Integer.MAX_VALUE, 0, visited);
    }

    private int dfs(int[] currPos, int[] dir, int min, int cost, boolean[][] visited) {
        if (currPos[0] == map.length - 1 &&
                currPos[1] == map[0].length - 1) return Math.min(min, cost + 100);

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int y = currPos[0];
        int x = currPos[1];
        visited[y][x] = true;

        for (int[] d : dirs) {
            int[] temp = {y + d[0], x + d[1]};
            if (!boundary(temp)) continue;
            if (map[temp[0]][temp[1]] == 1) continue;
            if (visited[temp[0]][temp[1]]) continue;

            min = Math.min(min, dfs(temp, d, min, cost + getPrice(dir, d), visited.clone()));
        }
        return min;
    }

    private int getPrice(int[] d1, int[] d2) {
        return isCorner(d1, d2) ? 500 : 100;
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
