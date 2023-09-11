//2023-09-11
//https://school.programmers.co.kr/learn/courses/30/lessons/12952
//N Queen

package codingtest_practice.level2;

public class NQueen {

    private int[] board;

    public int solution(int n) {
        board = new int[n];
        return dfs(0, n, 0);
    }

    private int dfs(int depth, int n, int answer) {
        if (depth == n) {
            return answer + 1;
        }

        for (int i = 0; i < n; i++) {
            board[depth] = i;
            if (isValid(depth)) {
                answer = dfs(depth + 1, n, answer);
            }
        }
        return answer;
    }

    private boolean isValid(int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[depth] == board[i] ||
                    Math.abs(depth - i) == Math.abs(board[depth] - board[i])) return false;
        }
        return true;
    }
}
