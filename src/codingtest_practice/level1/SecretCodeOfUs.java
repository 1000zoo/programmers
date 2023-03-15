//2023-02-07
//https://school.programmers.co.kr/learn/courses/30/lessons/155652
//둘만의 암호

package codingtest_practice.level1;

import java.util.*;

public class SecretCodeOfUs {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        List<Character> list = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            if (!skip.contains("" + c)) {
                list.add(c);
            }
        }

        for (char c : s.toCharArray()) {
            int temp = list.indexOf(c) + index;
            int alpIndex = checkBoundary(temp, list.size());
            answer.append((char) list.get(alpIndex));
        }
        return answer.toString();
    }

    private int checkBoundary(int index, int length) {
        return index < length ? index : index % length;
    }
}
