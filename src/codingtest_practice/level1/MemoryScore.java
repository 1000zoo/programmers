//2023-04-17 (resolved : 2023-08-14)
//https://school.programmers.co.kr/learn/courses/30/lessons/176963
//추억 점수

package codingtest_practice.level1;

import java.util.*;
import java.util.stream.IntStream;

public class MemoryScore {
    public int[] newSolution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        return Arrays.stream(photo).map(p -> Arrays.stream(p).mapToInt(s -> map.getOrDefault(s, 0)).sum()).mapToInt(i -> i).toArray();
    }

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
