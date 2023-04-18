//2023-04-18
//https://school.programmers.co.kr/learn/courses/30/lessons/181187
//두 원 사이의 정수 쌍

package codingtest_practice.level2;

public class IntegerPairsBetweenTwoCircle {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long maxY = (long) Math.floor(Math.sqrt((long)r2 * r2 - (long)x * x));
            long minY = r1 < x ? 0 : (long) Math.ceil(Math.sqrt((long)r1 * r1 - (long)x * x));
            answer += (maxY - minY + 1);
        }

        return answer * 4;
    }
}
