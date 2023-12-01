//2023-12-01
//https://school.programmers.co.kr/learn/courses/30/lessons/87694
//아이템 줍기

package codingtest_practice.level3;

import java.util.*;

public class PickItem {

    private final static int X_MAX = 102;
    private final static int Y_MAX = 102;

    private int[][] map;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[X_MAX][Y_MAX];
        draw(rectangle);
        return bfs(2 * characterX, 2 * characterY, 2 * itemX, 2 * itemY) / 4;
    }

    private int bfs(int startX, int startY, int endX, int endY) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int currX = startX;
        int currY = startY;
        queue.add(new int[] {currX, currY});
        int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (currX != endX || currY != endY) {
            int[] curr = queue.poll();
            currX = curr[0];
            currY = curr[1];
            count++;

            map[currX][currY] = -1; //visited
            for (int[] dir : dirs) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];

                if (map[nextX][nextY] == 1) {
                    queue.add(new int[] {nextX, nextY});
                }
            }
        }

        return count;
    }

    private void draw(int[][] rectangles) {
        for (int[] rectangle : rectangles) {
            draw(rectangle);
        }
    }

    private void draw(int[] rectangle) {
        int x1 = 2 * rectangle[0];
        int y1 = 2 * rectangle[1];
        int x2 = 2 * rectangle[2];
        int y2 = 2 * rectangle[3];

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 2) continue;
                map[i][j] = 2;
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    map[i][j] = 1;
                }
            }
        }

    }
}
