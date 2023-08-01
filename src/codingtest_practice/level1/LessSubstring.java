//2022-12-29 (resolve: 2023-08-02)
//https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java
//크기가 작은 부분 문자열

package codingtest_practice.level1;

import java.util.stream.*;

public class LessSubstring {

    public int newSolution(String t, String p) {
        return (int) IntStream.range(0, t.length() - p.length() + 1).filter(
                (i) -> Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p)
        ).count();
    }

    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String temp = t.substring(i, i + p.length());
            if (Long.parseLong(temp) <= Long.parseLong(p)) answer++;
        }

        return answer;
    }
}
