//정수 내림차순으로 배치하기
//https://school.programmers.co.kr/learn/courses/30/lessons/12933
//2022-09-14

package codingtest_practice.level1;

import java.util.Arrays;

public class DescendingLongType {

    //런타임 에러 (10 / 18)
    public static long solution1(long n) {
        String[] numbers = new String[10];
        Arrays.fill(numbers, "");
        StringBuilder sb = new StringBuilder();
        int number;
        long answer = 0l;

        while (n != 0) {
            number = (int) (n % 10);
            numbers[number] += number;
            n /= 10;
        }
        for (String num : numbers) {
            sb.append(num);
        }
        sb.reverse();
        String answerString = sb.toString();

        for (char i : answerString.toCharArray()) {
            answer += (i - '0');
            answer *= 10;
        }

        return answer / 10;
    }

    //pass
    public static long solution2(long n) {
        String numString = "" + n;
        long answer = 0l;
        int[] numbers = new int[10];
        for (char c : numString.toCharArray()) {
            numbers[c - '0']++;
        }
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < numbers[i]; j++) {
                answer *= 10;
                answer += i;
            }
        }
        return answer / 10;
    }

    public static void main(String[] args) {
        System.out.println(solution2(8000000000L));
        System.out.println(solution2(8613452345L));
    }
}
