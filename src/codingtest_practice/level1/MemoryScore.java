//2023-04-17
//https://school.programmers.co.kr/learn/courses/30/lessons/176963
//추억 점수

package codingtest_practice.level1;

import java.util.*;

public class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int points = 0;
            for (String person : photo[i]) {
                points += map.getOrDefault(person, 0);
            }
            answer[i] = points;
        }

        return answer;
    }
}
