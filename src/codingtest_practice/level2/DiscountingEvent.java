//https://school.programmers.co.kr/learn/courses/30/lessons/131127
//2023-01-02
//할인 행사

package codingtest_practice.level2;

import java.util.*;

public class DiscountingEvent {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> need = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> buy = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                buy.put(discount[j], buy.getOrDefault(discount[j], 0) + 1);
            }
            if (isSame(need, buy)) answer++;
        }

        return answer;
    }

    private boolean isSame(Map<String, Integer> need, Map<String, Integer> buy) {
        for (String item : need.keySet()) {
            if (!need.get(item).equals(buy.getOrDefault(item, 0))) {
                return false;
            }
        }
        return true;
    }
}
