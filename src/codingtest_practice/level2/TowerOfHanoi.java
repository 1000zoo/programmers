//2023-09-06
//https://school.programmers.co.kr/learn/courses/30/lessons/12946
//하노이의 탑

package codingtest_practice.level2;

import java.util.*;

public class TowerOfHanoi {

    private int[] currPos;
    private List<int[]> answer;

    public int[][] solution(int n) {
        currPos = new int[n + 1];
        Arrays.fill(currPos, 1);
        answer = new ArrayList<>();
        dfs(n, 3);

        int[][] ans = new int[answer.size()][];
        int index = 0;
        for (int[] a : answer) ans[index++] = a;
        return ans;
    }

    private void dfs(int n, int to) {
        if (n == 1) {
            answer.add(new int[] {currPos[n], to});
            currPos[n] = to;
            return;
        }

        dfs(n - 1, nextTo(n, to));
        answer.add(new int[] {currPos[n], to});
        currPos[n] = to;
        dfs(n - 1, to);

    }

    private int nextTo(int n, int to) {
        for (int i = 1; i <= 3; i++) {
            if (currPos[n] != i && to != i) return i;
        }
        return -1;
    }
}
