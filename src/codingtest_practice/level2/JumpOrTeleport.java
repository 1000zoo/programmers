//https://school.programmers.co.kr/learn/courses/30/lessons/12980#
//2022-10-18
//점프와 순간이동

package codingtest_practice.level2;

public class JumpOrTeleport {

    //효율성 테스트 탈락
    public int solution1(int n) {
        int[] past = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                past[i] = past[i / 2];
            } else {
                past[i] = past[i - 1] + 1;
            }
        }
        return past[n];
    }

    //solution2
    //재귀를 활용한 dynamic programming
    public int solution2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return solution2(n / 2);
        } else {
            return solution2(n - 1) + 1;
        }
    }
}
