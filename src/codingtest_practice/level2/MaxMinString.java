//https://school.programmers.co.kr/learn/courses/30/lessons/12939
//2022-09-21
//최대값과 최솟값

package codingtest_practice.level2;

public class MaxMinString {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int temp = 0;

        int startIndex = 0;
        int endIndex = s.indexOf(" ");

        //마지막 숫자를 위해서 (문제에서는 마지막에 space 가 없음)
        s += " ";

        while (endIndex != -1) {
            temp = toInt(s.substring(startIndex, endIndex));
            min = Math.min(temp, min);
            max = Math.max(temp, max);
            startIndex = endIndex + 1;
            endIndex = s.indexOf(" ", startIndex);
        }
        answer += min;
        answer += " ";
        answer += max;
        return answer;
    }

    private int toInt(String s) {
        int num = 0;
        int sign = 1;
        for (char n : s.toCharArray()) {
            if (n == '-') {
                sign = -1;
            } else {
                num *= 10;
                num += (n - '0');
            }
        }
        return sign * num;
    }
}
