//2023-09-04
//https://school.programmers.co.kr/learn/courses/30/lessons/140107
//점 찍기

package codingtest_practice.level2;

public class Dotting {
    public long solution(int k, int d) {
        long answer = 0;

        for (int i = 0; i * k <= d; i++) {
            double temp = Math.sqrt(Math.pow(d, 2) - Math.pow(i * k, 2));
            answer += Math.ceil(temp / k) + (temp % k == 0 ? 1 : 0);
        }

        return answer;
    }
}
