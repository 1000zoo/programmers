//2023-10-08
//https://school.programmers.co.kr/learn/courses/30/lessons/12907
//거스름돈

package codingtest_practice.level3;

public class MoneyChange {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] += (dp[i - m] % 1000000007);
            }
        }

        return dp[n];
    }
}
