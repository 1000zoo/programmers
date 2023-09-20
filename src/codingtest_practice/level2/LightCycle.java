//2023-09-20
//https://school.programmers.co.kr/learn/courses/30/lessons/86052#
//빛의 경로 사이클

package codingtest_practice.level2;

import java.util.*;

public class LightCycle {

    public int[] solution(String[] grid) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 우, 좌, 하, 상
        int h = grid.length;
        int w = grid[0].length();

        Set<String> visited = new HashSet<>();
        List<Integer> cycles = new ArrayList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int[] dir : dirs) {
                    String start = i + "," + j + "/" + dir[0] + "," + dir[1];

                    if (visited.contains(start)) {
                        continue;
                    }

                    int cycleLength = 0;
                    String curr = start;

                    while (!visited.contains(curr)) {
                        visited.add(curr);
                        cycleLength++;

                        String[] parts = curr.split("/");
                        int[] pos = Arrays.stream(parts[0].split(",")).mapToInt(Integer::parseInt).toArray();
                        int[] currDir = Arrays.stream(parts[1].split(",")).mapToInt(Integer::parseInt).toArray();

                        int nextI = (h + pos[0] + currDir[0]) % h;
                        int nextJ = (w + pos[1] + currDir[1]) % w;
                        char c = grid[nextI].charAt(nextJ);

                        int[] nextDir = dirByReflection(c, currDir);
                        curr = nextI + "," + nextJ + "/" + nextDir[0] + "," + nextDir[1];
                    }

                    cycles.add(cycleLength);
                }
            }
        }

        Collections.sort(cycles);
        return cycles.stream().mapToInt(i -> i).toArray();
    }

    private int[] dirByReflection(char c, int[] dir) {
        if (c == 'S') return dir;
        if (c == 'L') return new int[]{-dir[1], dir[0]};
        if (c == 'R') return new int[]{dir[1], -dir[0]};
        return null;
    }
}
