//2023-07-20
//https://school.programmers.co.kr/learn/courses/30/lessons/68645
//삼각 달팽이

package codingtest_practice.level2;

import java.util.*;
import java.util.stream.IntStream;

public class TriSnail {
    private int[][] tri;
    private int[][] direction = {{1, 0}, {0, 1}, {-1, -1}};
    public int[] solution(int n) {
        if (n == 1) return new int[] {1};
	tri = new int[n][];
        for (int i = 0; i < n; i++) tri[i] = new int[i + 1];
        int max = IntStream.range(1, n + 1).sum();
        int index = 0;
        int[] curr = new int[] {0, 0};

        for (int i = 1; i <= max; i++) {
            tri[curr[0]][curr[1]] = i;
            int[] next = getNext(curr, index);
            if (!isWithinBoundary(next)) {
                index = (index + 1) % 3;
                next = getNext(curr, index);
            }
            if (tri[next[0]][next[1]] != 0) {
                index = (index + 1) % 3;
                next = getNext(curr, index);
            }
            curr = next;
        }
        int[] answer = new int[max];
        index = 0;
        for (int i = 0; i < tri.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[index++] = tri[i][j];
            }
        }

        return answer;
    }
    private int[] getNext(int[] curr, int dir) {
        return new int[] {curr[0] + direction[dir][0], curr[1] + direction[dir][1]};
    }

    private boolean isWithinBoundary(int[] curr) {
        return 0 <= curr[0] && curr[0] < tri.length && 0 <= curr[1] && curr[1] < tri[curr[0]].length;
    }
}
