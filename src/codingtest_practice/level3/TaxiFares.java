//2023-09-30
//https://school.programmers.co.kr/learn/courses/30/lessons/72413
//택시 합승 요금

package codingtest_practice.level3;

import java.util.Arrays;

public class TaxiFares {

    private final int MAX = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX;
        int[][] dp = new int[n + 1][n + 1];
        setDp(fares, dp);
        floydWarshall(dp);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dp[s][i] + dp[i][a] + dp[i][b]);
        }

        return answer;
    }

    private void floydWarshall(int[][] dp) {
        for (int k = 1; k < dp.length; k++) {
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp.length; j++) {
                    int sum = dp[i][k] + dp[k][j];
                    if (dp[i][k] == MAX || dp[k][j] == MAX) {
                        sum = MAX;
                    }
                    dp[i][j] = Math.min(dp[i][j], sum);
                }
            }
        }
    }

    private void setDp(int[][] fares, int[][] dp) {
        for (int[] d : dp) {
            Arrays.fill(d, MAX);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }

        for (int[] fare : fares) {
            dp[fare[0]][fare[1]] = fare[2];
            dp[fare[1]][fare[0]] = fare[2];
        }
    }
}
