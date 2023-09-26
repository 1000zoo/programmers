//2023-04-06 (새로운 풀이: 2023-09-26)
//https://school.programmers.co.kr/learn/courses/30/lessons/118666
//성격 유형 검사하기

package codingtest_practice.level1;

import java.util.*;

public class KakaoMBTI {

    public String newSolution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        char[] category = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char c : category) {
            map.put(c, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            recordScore(map, survey[i], choices[i]);
        }

        for (int i = 0; i < category.length; i += 2) {
            answer += map.get(category[i]) >= map.get(category[i + 1]) ? category[i] : category[i + 1];
        }

        return answer;
    }

    private void recordScore(Map<Character, Integer> map, String survey, int choice) {
        int score = choice - 4;
        if (score == 0) return;
        int i = Math.max(Integer.compare(score, 0), 0);
        char c = survey.charAt(i);
        map.put(c, map.get(c) + Math.abs(score));
    }


    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] indicators = {"RT", "CF", "JM", "AN"};
        final int NOTHING = 4;
        Map<Character, Integer> type_score = new HashMap<>();
        for (String ind : indicators) {
            for (char t : ind.toCharArray()) {
                type_score.put(t, 0);
            }
        }

        for (int i = 0; i < survey.length; i++) {
            String s = survey[i];
            int score = choices[i] - NOTHING;

            char pType = score < 0 ? s.charAt(0) : s.charAt(1);

            type_score.put(pType, type_score.get(pType) + Math.abs(score));
        }

        for (String ind : indicators) {
            char first = ind.charAt(0), second = ind.charAt(1);
            if (type_score.get(first) == type_score.get(second)) {
                answer += (char) Math.min(first, second);
            } else {
                answer += type_score.get(first) > type_score.get(second) ? first : second;
            }
        }

        return answer;
    }
}
