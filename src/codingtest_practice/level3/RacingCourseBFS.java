//2023-11-22
//https://school.programmers.co.kr/learn/courses/30/lessons/67259
//경주로 건설 (BFS 풀이)

package codingtest_practice.level3;

import java.util.*;

public class RacingCourseBFS {

    private static class State {
        private final int[] prev;
        private final int[] curr;
        private final int cost;

        public State() {
            this.prev = new int[] {0, 0};
            this.curr = new int[] {0, 0};
            this.cost = 0;
        }

        public State(int[] prev, int[] curr, int cost) {
            this.prev = prev;
            this.curr = curr;
            this.cost = cost;
        }

        public boolean isCurve(int[] next) {
            if (curr[0] == 0 && curr[1] == 0) return false;
            return prev[0] - curr[0] != curr[0] - next[0];
        }
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<State> queue = new LinkedList<>();
        int[][] dp = new int[board.length][board.length];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        State start = new State();
        queue.add(start);

        while (!queue.isEmpty()) {
            State curr = queue.poll();
            int[] coor = curr.curr;

            if (coor[0] == board.length - 1 && coor[1] == board.length - 1) {
                answer = Math.min(answer, curr.cost);
                continue;
            }

            for (int[] dir : dirs) {
                int[] next = add(coor, dir);
                if (!isPossible(board, next)) continue;
                if (dp[next[0]][next[1]] <= curr.cost) continue;

                if (curr.isCurve(next)) {
                    dp[next[0]][next[1]] = curr.cost + 600;
                    queue.add(new State(coor, next, curr.cost + 600));
                } else {
                    dp[next[0]][next[1]] = curr.cost + 100;
                    queue.add(new State(coor, next, curr.cost + 100));
                }
            }
        }

        return answer;
    }

    private int[] add(int[] a, int[] b) {
        return new int[] {a[0] + b[0], a[1] + b[1]};
    }

    private boolean isPossible(int[][] board, int[] curr) {
        return 0 <= curr[0] && curr[0] < board.length && 0 <= curr[1] && curr[1] < board.length
                && board[curr[0]][curr[1]] == 0;
    }
}
