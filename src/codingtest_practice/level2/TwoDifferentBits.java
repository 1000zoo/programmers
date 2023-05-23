//2023-05-24
//https://school.programmers.co.kr/learn/courses/30/lessons/77885#
//2개 이하로 다른 비트

package codingtest_practice.level2;

public class TwoDifferentBits {



    public long[] timeLimitedFailed(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            while (getDiffBits(++num, numbers[i]) > 2)
            answer[i] = num;
        }

        return answer;
    }

    private int getDiffBits(long l1, long l2) {
        long temp = l1 ^ l2;
        return countOne(Long.toBinaryString(temp));
    }
    private int countOne(String binary) {
        int ans = 0;
        for (char b : binary.toCharArray()) if (b == '1') ans++;
        return ans;
    }
}
