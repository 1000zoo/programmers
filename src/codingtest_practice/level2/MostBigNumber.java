//2023-07-11
//https://school.programmers.co.kr/learn/courses/30/lessons/42746#
//가장 큰 수

package codingtest_practice.level2;

import java.util.*;

public class MostBigNumber {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        List<String> list = new ArrayList<>();
        for (int n : numbers) {
            list.add("" + n);
        }
        list.sort((s1, s2) -> compare(s2, s1));
        for (String s : list) {
            answer.append(s);
        }

        return answer.toString().charAt(0) == '0' ? "0" : answer.toString();
    }

    private int compare(String s1, String s2) {
        String case1 = s1 + s2;
        String case2 = s2 + s1;
        return case1.compareTo(case2);
    }
}
