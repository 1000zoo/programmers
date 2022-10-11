//https://school.programmers.co.kr/learn/courses/30/lessons/12981
//2022-10-11
//영어 끝말 잇

package codingtest_practice.level2;

import java.util.HashSet;

public class EnglishWordRelay {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char prev = words[0].charAt(words[0].length() - 1);
        HashSet<String> history = new HashSet<>(){{
            add(words[0]);
        }};

        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) == prev && !history.contains(words[i])) {
                history.add(words[i]);
                prev = words[i].charAt(words[i].length() - 1);
            } else {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }
}
