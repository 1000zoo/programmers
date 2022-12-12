package codingtest_practice.level2;

import java.util.*;

public class ShortestDistanceOnGameMap {

    private int[][] map;
    private Set<String> visited = new HashSet<>();
    private boolean arrive = false;

    public int solution(int[][] maps) {
        map = maps;
        int answer = dfs(new int[] {0, 0}, Integer.MAX_VALUE, 1);
        return arrive ? answer : -1;
    }

    private int dfs(int[] curr, int min, int count) {
        Stack<int[]> actions = getAction(curr);
        if (actions.isEmpty()) {
            if (curr[0] == map[0].length - 1 && curr[1] == map.length - 1) {
                arrive = true;
                return Math.min(count, min);
            }
            return min;
        }

        while (!actions.isEmpty()) {
            int[] next = actions.pop();
            visited.add(encode(next));
            min = Math.min(dfs(next, min, count + 1), min);
            visited.remove(encode(next));
        }
        return min;
    }

    public Stack<int[]> getAction(int[] curr) {
        Stack<int[]> actions = new Stack<>();
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int[] next = new int[] {curr[0] + dir[0], curr[1] + dir[1]};
            if (checkBoundary(next)) {
                if (map[next[1]][next[0]] == 1 && !visited.contains(encode(next))) {
                    actions.push(next);
                }
            }
        }
        return actions;
    }

    private String encode(int x, int y) {
        return x + "/" + y;
    }
    private String encode(int[] coor) {
        return coor[0] + "/" + coor[1];
    }

    private int[] decode(String code) {
        String[] temp = code.split("/");
        return new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
    }

    private boolean checkBoundary(int[] next) {
        return next[0] >= 0 && next[0] < map[0].length && next[1] >= 0 && next[1] < map.length;
    }
}
