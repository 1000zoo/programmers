//2023-05-18
//https://school.programmers.co.kr/learn/courses/30/lessons/120866
//안전지대

package codingtest_practice.level0;

public class SafeArea {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] dir = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int length = board.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == 1) {
                    for (int[] d : dir) {
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if (isWithinBoundary(ni, nj, length) && board[ni][nj] != 1) {
                            board[ni][nj] = 2;
                        }
                    }
                }
            }
        }

        for (int[] r : board) {
            for (int c : r) {
                answer += c == 0 ? 1 : 0;
            }
        }

        return answer;
    }

    public boolean isWithinBoundary(int x, int y, int length) {
        return 0 <= x && x < length && 0 <= y && y < length;
    }
}
