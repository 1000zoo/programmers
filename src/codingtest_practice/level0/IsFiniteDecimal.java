//2023-06-15
//https://school.programmers.co.kr/learn/courses/30/lessons/120878
//유한소수 판별하기

package codingtest_practice.level0;

public class IsFiniteDecimal {

    public int solution(int a, int b) {
        int answer = 0;
        int[] irr = irreducibleFraction(a, b);
        return isFinite(irr[0], irr[1]) ? 1 : 2;
    }

    private int[] irreducibleFraction(int a, int b) {
        for (int i = 2; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
                i--;
            }
        }
        return new int[] {a, b};
    }

    private boolean isFinite(int a, int b) {
        while (b > 1) {
            if (b % 2 == 0) {
                b /= 2;
            } else if (b % 5 == 0) {
                b /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
