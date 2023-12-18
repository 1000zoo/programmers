//2023-12-18
//https://school.programmers.co.kr/learn/courses/30/lessons/250136
//석유 시추

package codingtest_practice.level2;

import java.util.*;

public class OilDrilling {

    private int[] parent;
    private int[] size;

    public int solution(int[][] land) {
        int n = land.length, m = land[0].length;
        parent = new int[n * m];
        size = new int[n * m];

        for (int i = 0; i < n * m; i++) {
            parent[i] = i;
            size[i] = (land[i / m][i % m] == 1) ? 1 : 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    if (i > 0 && land[i - 1][j] == 1) union(i * m + j, (i - 1) * m + j);
                    if (j > 0 && land[i][j - 1] == 1) union(i * m + j, i * m + j - 1);
                }
            }
        }

        int answer = 0;
        for (int j = 0; j < m; j++) {
            Set<Integer> seen = new HashSet<>();
            int total = 0;
            for (int i = 0; i < n; i++) {
                int idx = find(i * m + j);
                if (land[i][j] == 1 && !seen.contains(idx)) {
                    total += size[idx];
                    seen.add(idx);
                }
            }
            answer = Math.max(answer, total);
        }
        return answer;
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
    }

    private int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
