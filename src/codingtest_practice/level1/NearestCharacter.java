//https://school.programmers.co.kr/learn/courses/30/lessons/142086
//2022-12-30
//가장 가까운 같은 글자

package codingtest_practice.level1;

import java.util.*;

public class NearestCharacter {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.keySet().contains(s.charAt(i))) {
                answer[i] = i - map.get(s.charAt(i));
            } else {
                answer[i] = -1;
            }
            map.put(s.charAt(i), i);
        }

        return answer;
    }
}
