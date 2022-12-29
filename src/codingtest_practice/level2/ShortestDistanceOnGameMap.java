//https://school.programmers.co.kr/learn/courses/30/lessons/1844#
//2022-12-29
//게임 맵 최단거리

package codingtest_practice.level2;

import java.util.*;

class ShortestDistanceOnGameMap {
    private int[][] map;

    //참조 : https://school.programmers.co.kr/questions/38232
    public int solution(int[][] maps) {
        map = maps;
        boolean[][] visitied = new boolean[maps.length][maps[0].length];
        Queue<int[]> nodes = new LinkedList<>();
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        nodes.add(new int[]{0, 0});

        while (!nodes.isEmpty()) {
            int[] curr = nodes.remove();
            int x = curr[0];
            int y = curr[1];

            if (x == map[0].length - 1 && y == map.length - 1) {
                return map[y][x];
            }

            for (int[] d : dir) {
                int tempX = curr[0] + d[0];
                int tempY = curr[1] + d[1];
                if (!canMove(tempX, tempY) || !isRoad(tempX, tempY)) continue;

                if (isRoad(tempX, tempY) && !visitied[tempY][tempX]) {
                    visitied[y][x] = true;
                    nodes.add(new int[]{tempX, tempY});
                    map[tempY][tempX] = map[y][x] + 1;
                }
            }
        }

        return -1;
    }

    private boolean canMove(int x, int y) {
        return x >= 0 && x < map[0].length && y >= 0 && y < map.length;
    }

    private boolean isRoad(int x, int y) {
        return map[y][x] != 0;
    }
}