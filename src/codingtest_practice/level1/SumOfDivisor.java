//약수의 합
//https://school.programmers.co.kr/learn/courses/30/lessons/12928

package codingtest_practice.level1;

public class SumOfDivisor {
    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                answer += i;
                System.out.println(i);
            }
        }
        return answer + n;
    }
}
