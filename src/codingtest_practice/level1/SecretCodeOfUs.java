//2023-02-07
//https://school.programmers.co.kr/learn/courses/30/lessons/155652
//둘만의 암호

package codingtest_practice.level1;

import java.util.*;

public class SecretCodeOfUs {

    //런타임 에러
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> alpList = new HashMap<>();
        Map<Integer, Character> indList = new HashMap<>();
        Set<Character> skipSet = new HashSet<>();

        for (char c : skip.toCharArray()) {
            skipSet.add(c);
        }

        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (!skipSet.contains(c)) {
                alpList.put(c, i);
                indList.put(i++, c);
            }
        }

        for (char c : s.toCharArray()) {
            int temp = alpList.get(c) + index;
            int alpIndex = checkBoundary(temp, alpList.size());
            answer.append((char) (indList.get(alpIndex)));
        }
        return answer.toString();
    }

    //index - length 로 할 경우,
    //index - length > length 일 때 null 관련 에러발생
    //=> index % length
    private int checkBoundary(int index, int length) {
        return index < length ? index : index % length;
    }
}
