//https://school.programmers.co.kr/learn/courses/30/lessons/12985
//2022-10-18
//예상 대진표

package codingtest_practice.level2;

public class ExpectedListOfMatches {
    public int solution(int n, int a, int b) {
        int answer = 1;
        while (!gameOf(a, b)) {
            answer++;
            a = nextNumber(a);
            b = nextNumber(b);
        }
        return answer;
    }

    private boolean gameOf(int a, int b) {
        int less = Math.min(a, b);
        int bigger = Math.max(a, b);
        return less % 2 == 1 && bigger - less == 1;
    }

    private int nextNumber(int n) {
        return n % 2 == 0 ? n / 2 : n / 2 + 1;
    }
}
