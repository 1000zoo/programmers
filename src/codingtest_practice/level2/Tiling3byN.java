//2023-09-19
//https://school.programmers.co.kr/learn/courses/30/lessons/12902#
//3 * n 타일링

package codingtest_practice.level2;

public class Tiling3byN {
    public int solution(int n) {
        if (n % 2 == 1) return 0;

        long[] dp = new long[n + 1];
        long sum = 0;
        dp[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            dp[i] = (dp[i - 2] * 3 + (sum * 2 + 2))% 1000000007;
            sum += dp[i - 2]% 1000000007;
        }

        return (int) dp[n];
    }
}
