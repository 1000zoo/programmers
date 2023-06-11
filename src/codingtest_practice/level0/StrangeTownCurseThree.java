//2023-06-12
//https://school.programmers.co.kr/learn/courses/30/lessons/120871
//저주의 숫자 3

package codingtest_practice.level0;

public class StrangeTownCurseThree {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        int i = 1;

        for (int real = 1; i < n + 1; real++) {
            if (real % 3 != 0 && !Integer.toString(real).contains("3")) {
                dp[i++] = real;
            }
        }

        return dp[n];
    }
}
