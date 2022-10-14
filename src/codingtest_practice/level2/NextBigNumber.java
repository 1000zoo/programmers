//https://school.programmers.co.kr/learn/courses/30/lessons/12911
//2022-10-14
//다음 큰 숫자

package codingtest_practice.level2;

public class NextBigNumber {
    public int solution(int n) {
        int inc = 1;
        int count = countOne(n);
        while (true) {
            int temp = countOne(++n);
            if (temp == count) {
                break;
            }
        }
        return n;
    }
    private int countOne(int n) {
        String bin = Integer.toBinaryString(n);
        int count = 0;
        for (char c : bin.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
