//https://school.programmers.co.kr/learn/courses/30/lessons/42586
//2022-10-22
//기능 개발

package codingtest_practice.level2;

import java.util.*;

public class DevelopOrder {
    public int[] solution(int[] progresses, int[] speeds) {
        if (progresses == null || speeds == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int dayMax = 0;
        for (int i = 0; i < progresses.length; i++) {
            int time = getTime(progresses[i], speeds[i]);
            if (!st.isEmpty()) {
                dayMax = Math.max(st.peek(), dayMax);
                if (dayMax < time) {
                    list.add(st.size());
                    while (!st.isEmpty()) {
                        st.pop();
                    }
                }
            }
            st.push(time);
        }
        if (!st.isEmpty()) {
            list.add(st.size());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int getTime(int progress, int speed) {
        int rest = (100 - progress);
        return rest % speed == 0 ? rest / speed : 1 + rest / speed;
    }
}
