//https://school.programmers.co.kr/learn/courses/30/lessons/87946
//2022-11-07
//피로도

package codingtest_practice.level2;

import java.util.*;

public class Fatigue {

    public int[][] dungeons;
    public ArrayList<Integer> list = new ArrayList<>();

    public int solution(int k, int[][] d) {

        dungeons = d;
        int max = 0;
        dfs(k, 0, 0, new HashSet<>());
        for (int i : list) {
            max = Math.max(max, i);
        }
        return max;
    }

    private void dfs(int k, int depth, int pass, HashSet<Integer> path) {
        if (depth == dungeons.length) {
            list.add(pass);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!path.contains(i)) {
                path.add(i);
                if (dungeons[i][0] <= k) {
                    dfs(k - dungeons[i][1], depth + 1, pass + 1, path);
                } else {
                    dfs(k, depth + 1, pass, path);
                }
                path.remove(i);
            }
        }
    }
}
