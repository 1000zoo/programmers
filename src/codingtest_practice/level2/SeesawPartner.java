//2023-09-04
//https://school.programmers.co.kr/learn/courses/30/lessons/152996#
//시소 짝궁

package codingtest_practice.level2;

import java.util.*;

public class SeesawPartner {

    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Set<Integer>> pair = setPair(weights);
        Map<Integer, Integer> numOf = setNumOf(weights);

        for (int w : weights) {
            Set<Integer> pairSet = pair.get(w);

            for (int p : pairSet) {
                int num = numOf.getOrDefault(p, 0);
                if (w == p) {
                    answer += num > 1 ? num - 1 : 0;
                } else {
                    answer += num;
                }
            }
        }

        return answer / 2;
    }

    private Map<Integer, Set<Integer>> setPair(int[] weights) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int w : weights) {
            if (map.containsKey(w)) continue;
            map.put(w, getPairsOf(w));
        }

        return map;
    }

    private Map<Integer, Integer> setNumOf(int[] weights) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int w : weights) map.put(w, map.getOrDefault(w, 0) + 1);
        return map;
    }

    private Set<Integer> getPairsOf(int weight) {
        Set<Integer> set = new HashSet<>();

        for (int i = 2; i <= 4; i++) {
            for (int j = 2; j <= 4; j++) {
                if ((i * weight) % j == 0) set.add((i * weight) / j);
            }
        }

        return set;
    }
}
