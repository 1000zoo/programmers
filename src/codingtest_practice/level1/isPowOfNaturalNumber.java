//정수 제곱근 판별
//https://school.programmers.co.kr/learn/courses/30/lessons/12934#

package codingtest_practice.level1;

public class isPowOfNaturalNumber {
    public long solution(long n) {
        if (n == 1) return 4;
        long answer = -1;
        for (long i = 1; i <= n / 2; i++) {
            if (i * i == n) {
                answer = i;
                break;
            }
        }
        if (answer == -1) return answer;
        answer += 1;
        answer *= answer;
        return answer;
    }
}
