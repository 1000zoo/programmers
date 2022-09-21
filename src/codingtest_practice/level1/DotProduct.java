//https://school.programmers.co.kr/learn/courses/30/lessons/70128
//2022-09-21
//내적

package codingtest_practice.level1;

public class DotProduct {
    public int solution(int[] a, int[] b) {
        if (a.length != b.length) {
            return -1;
        }
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += (a[i] * b[i]);
        }
        return answer;
    }
}
