//https://school.programmers.co.kr/learn/courses/30/lessons/12924
//2022-10-05
//숫자의 표현

package codingtest_practice.level2;

public class ExpressionNumber {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int tempSum = 0;
            int j = i;
            while (tempSum < n) {
                tempSum += j;
                j++;
            }
            if (tempSum == n) {
                answer++;
            }
        }

        return answer;
    }
}
