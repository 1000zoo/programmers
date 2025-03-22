package codingtest_practice.level2;

public class MinimizeThiefTrace {
    public int solution(int[][] info, int n, int m) {
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;

        for (int[] item : info) {
            boolean[][] newDp = new boolean[n][m];

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (!dp[a][b]) continue;

                    int newA = a + item[0];
                    int newB = b + item[1];

                    if (newA < n) {
                        newDp[newA][b] = true;
                    }
                    if (newB < m) {
                        newDp[a][newB] = true;
                    }
                }
            }
            dp = newDp;
        }

        int answer = Integer.MAX_VALUE;

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (dp[a][b]) {
                    answer = Math.min(answer, a);
                }
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
