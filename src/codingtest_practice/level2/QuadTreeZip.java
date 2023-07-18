//쿼드 압축 후 개수 세기
//https://school.programmers.co.kr/learn/courses/30/lessons/68936#
//2023-07-18

package codingtest_practice.level2;

import java.util.*;

public class QuadTreeZip {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[] {0, 0};
        if (allSame(arr)) {
            answer[arr[0][0]]++;
            return answer;
        }
        dfs(arr);
        return answer;
    }

    private void dfs(int[][] node) {
        if (node.length == 1) {
            answer[node[0][0]]++;
            return;
        }
        int w = node.length / 2;
        int[][] range = {{0, w}, {w, node.length}};
        for (int[] colRange : range) {
            for (int[] rowRange : range) {
                int cStart = colRange[0];
                int cEnd = colRange[1];
                int rStart = rowRange[0];
                int rEnd = rowRange[1];
                int[][] copy = new int[rEnd - rStart][];
                for (int i = 0; i < rEnd - rStart; i++) {
                    copy[i] = Arrays.copyOfRange(node[i + rStart], cStart, cEnd);
                }
                if (allSame(copy)) answer[copy[0][0]]++;
                else dfs(copy);
            }
        }
    }

    private boolean allSame(int[][] sq) {
        int n = sq[0][0];
        for (int[] r : sq) {
            for (int c : r) {
                if (n != c) return false;
            }
        }
        return true;
    }
}
