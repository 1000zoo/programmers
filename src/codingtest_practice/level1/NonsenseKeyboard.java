//2023-06-27
//https://school.programmers.co.kr/learn/courses/30/lessons/160586
//대충 만든 자판

package codingtest_practice.level1;

public class NonsenseKeyboard {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            for (char c : target.toCharArray()) {
                String temp = "" + c;
                int minCase = Integer.MAX_VALUE;

                for (String key : keymap) {
                    int click = key.indexOf(temp);
                    minCase = Math.min(minCase, click == -1 ? Integer.MAX_VALUE : click + 1);
                }
                if (minCase == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += minCase;
                }
            }
        }

        return answer;
    }
}
