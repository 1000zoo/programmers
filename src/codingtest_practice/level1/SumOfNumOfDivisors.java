//2023-05-22
//https://school.programmers.co.kr/learn/courses/30/lessons/136798
//기사단원의 무기 (자연수들의 약수의 개수의 합)

package codingtest_practice.level1;

public class SumOfNumOfDivisors {
    int[] dp;
    public int solution(int number, int limit, int power) {
        int answer = 0;
        dp = new int[number + 1];
        for (int i = 0; i <= number; i++) dp[i] = 1;
        setDP();
        for (int i = 1; i <= number; i++) {
            int temp = dp[i];
            answer += temp <= limit ? temp : power;
        }

        return answer;
    }

    private void setDP() {
        for (int i = 2; i < dp.length; i++) {
            int j = i;
            while (j < dp.length) {
                dp[j]++;
                j += i;
            }
        }
    }
}
