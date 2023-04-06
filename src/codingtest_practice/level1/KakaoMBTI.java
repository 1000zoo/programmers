//2023-04-06
//https://school.programmers.co.kr/learn/courses/30/lessons/118666
//성격 유형 검사하기

package codingtest_practice.level1;

import java.util.*;

public class KakaoMBTI {

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
