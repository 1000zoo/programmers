//2023-08-31
//https://school.programmers.co.kr/learn/courses/30/lessons/148653
//마법의 엘레베이터

package codingtest_practice.level2;

public class MagicElevator {
    private int s;
    private int answer;
    public int solution(int storey) {
        s = storey;
        answer = 0;

        while (s != 0) {
            int d = s % 10;
            if (d < 5 || (d == 5 && (s / 10) % 10 < 5)) {
                up(d);
            } else {
                down(d);
            }
        }

        return answer;
    }

    private void up(int d) {
        s /= 10;
        answer += d;
    }
    private void down(int d) {
        s /= 10;
        s += 1;
        answer += (10 - d);
    }
}