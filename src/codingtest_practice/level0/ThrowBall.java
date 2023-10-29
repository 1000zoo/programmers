//2023-10-29
//https://school.programmers.co.kr/learn/courses/30/lessons/120843
//공던지기

package codingtest_practice.level0;

public class ThrowBall {
    public int solution(int[] numbers, int k) {
        return numbers[((k - 1) * 2) % numbers.length];
    }
}
