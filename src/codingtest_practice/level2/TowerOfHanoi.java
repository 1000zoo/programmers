//2023-09-06
//https://school.programmers.co.kr/learn/courses/30/lessons/12946
//하노이의 탑

package codingtest_practice.level2;

import java.util.*;

public class TowerOfHanoi {

    private int index;
    private int[] currPos;
    private int[][] answer;

    public int[][] solution(int n) {
        index = 0;
        currPos = new int[n + 1];
        Arrays.fill(currPos, 1);
        answer = new int[(int) Math.pow(2, n) - 1][];
        dfs(n, 3);

        return answer;
    }

    private void dfs(int n, int to) {
        if (n == 1) {
            answer[index++] = new int[] {currPos[n], to};
            currPos[n] = to;
            return;
        }

        dfs(n - 1, nextTo(n, to));
        answer[index++] = new int[] {currPos[n], to};
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
