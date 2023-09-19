//2023-09-20
//https://school.programmers.co.kr/learn/courses/30/lessons/148652
//유사 칸토어 비트

package codingtest_practice.level2;

public class CantorBit {

    //refer: https://school.programmers.co.kr/questions/49643
    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long i = l - 1; i < r; i++) {
            answer += check(i) ? 1 : 0;
        }

        return answer;
    }

    private boolean check(long n) {
        if (n % 5 == 2) return false;
        if (n < 5) return true;
        return check(n / 5);
    }
}
