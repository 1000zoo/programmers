//2023-10-27
//https://school.programmers.co.kr/learn/courses/30/lessons/150365
//미로 탈출 명령어

package codingtest_practice.level3;

public class MazeEscapeCommand {

    private StringBuilder answer;
    private int MAX_N;
    private int MAX_M;
    private int END_X;
    private int END_Y;
    private int MAX_K;
    private boolean finish;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = new StringBuilder();
        finish = false;
        MAX_N = n;
        MAX_M = m;
        END_X = r;
        END_Y = c;
        MAX_K = k;

        if (!isPossible(x, y, r, c, k) || !canGo(x, y)) {
            return "impossible";
        }
        dfs(x, y);
        return answer.toString();
    }

    private void dfs(int currX, int currY) {
        if (!canGo(currX, currY)) {
            return;
        }
        if (finish) {
            return;
        }
        if (answer.length() == MAX_K) {
            if (currX == END_X && currY == END_Y) {
                finish = true;
            }
            return;
        }

        String[] dirNames = {"d", "l", "r", "u"};
        int[][] dir = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        for (int i = 0; i < dir.length; i++) {
            int nextX = currX + dir[i][0];
            int nextY = currY + dir[i][1];
            if (nextX < 1 || nextX > MAX_N) continue;
            if (nextY < 1 || nextY > MAX_M) continue;
            answer.append(dirNames[i]);
            dfs(nextX, nextY);
            if (finish) {
                return;
            }
            answer.delete(answer.length() - 1, answer.length());
        }
    }

    private boolean canGo(int currX, int currY) {
        int dp = Math.abs(currX - END_X) + Math.abs(currY - END_Y);
        return dp <= MAX_K - answer.length();
    }

    private boolean isPossible(int x, int y, int r, int c, int k) {
        int dp = Math.abs(x - r) + Math.abs(y - c);
        int r1 = dp % 2;
        int r2 = k % 2;

        return r1 == r2;
    }
}
