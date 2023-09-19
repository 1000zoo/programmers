//2023-09-20
//https://school.programmers.co.kr/learn/courses/30/lessons/1829
//카카오프렌즈 컬러링북

package codingtest_practice.level2;

import java.util.*;

public class ColoringBook {

    public int[] solution(int m, int n, int[][] picture) {
        int area = 0;
        int maxArea = 0;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0) continue;
                if (visited[i][j]) continue;
                int color = picture[i][j];
                int currArea = 0;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {i, j});

                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    if (!checkBoundary(m, n, curr)) continue;
                    if (picture[curr[0]][curr[1]] == 0) continue;
                    if (picture[curr[0]][curr[1]] != color) continue;
                    if (visited[curr[0]][curr[1]]) continue;

                    q.add(new int[] {curr[0] - 1, curr[1]});
                    q.add(new int[] {curr[0], curr[1] - 1});
                    q.add(new int[] {curr[0] + 1, curr[1]});
                    q.add(new int[] {curr[0], curr[1] + 1});

                    visited[curr[0]][curr[1]] = true;
                    currArea++;
                }
                maxArea = Math.max(maxArea, currArea);
                area++;
            }
        }

        return new int[] {area, maxArea};
    }

    private boolean checkBoundary(int m, int n, int[] pos) {
        return 0 <= pos[0] && pos[0] < m && 0 <= pos[1] && pos[1] < n;
    }
}
