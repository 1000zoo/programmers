package codingtest_practice.level3;

public class AvantGardeTiling {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 10;
        if (n <= 3) return dp[n];
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1_000_000_007;
        }

        return dp[n];
    }
}
