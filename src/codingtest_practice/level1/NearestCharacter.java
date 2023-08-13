//https://school.programmers.co.kr/learn/courses/30/lessons/142086
//2022-12-30 (resolved: 2023-08-13)
//가장 가까운 같은 글자

package codingtest_practice.level1;

import java.util.*;
import java.util.stream.IntStream;

public class NearestCharacter {

    public int[] newSolution(String s) {
        return IntStream.range(0, s.length())
            .map(i -> {
                int index = s.substring(0, i).lastIndexOf(s.charAt(i));
                return index == -1 ? -1 : i - index;
            }
                )
            .toArray();
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                answer[i] = i - map.get(s.charAt(i));
            } else {
                answer[i] = -1;
            }
            map.put(s.charAt(i), i);
        }

        return answer;
    }
}
