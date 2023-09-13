//2023-09-13
//https://school.programmers.co.kr/learn/courses/30/lessons/42576?
//완주하지 못한 선수

package codingtest_practice.level1;

import java.util.*;

public class UncompletedParticipant {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) - 1);
            if (map.get(p) < 0) return p;
        }

        return answer;
    }
}
