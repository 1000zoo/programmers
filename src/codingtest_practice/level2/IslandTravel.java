//2023-01-30
//https://school.programmers.co.kr/learn/courses/30/lessons/154540
//무인도 여행

package codingtest_practice.level2;

import java.util.*;

public class IslandTravel {
    private boolean[][] visited;
    private char[][] map;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                int temp = dfs(i, j);
                if (temp > 0) answer.add(temp);
            }
        }

        Collections.sort(answer);
        return answer.isEmpty() ? new int[] { -1 } : answer.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(int row, int col) {
        if (row < 0 || row == map.length || col < 0 || col == map[0].length) return 0;

        if (visited[row][col]) return 0;
        if (map[row][col] == 'X') return 0;

        int res = map[row][col] - '0';
        visited[row][col] = true;

        res += dfs(row, col + 1);
        res += dfs(row + 1, col);
        res += dfs(row - 1, col);
        res += dfs(row, col - 1);

        return res;
    }
}
