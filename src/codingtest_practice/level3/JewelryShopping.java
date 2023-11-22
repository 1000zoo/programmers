//2023-08-20 (새로운 풀이: 2023-11-22)
//https://school.programmers.co.kr/learn/courses/30/lessons/67258
//보석 쇼

package codingtest_practice.level3;

import java.util.*;

public class JewelryShopping {

    public int[] solution(String[] gems) {
        int[] answer = new int[] {0, gems.length};
        Map<String, Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>(Arrays.asList(gems));

        int left = 0;
        int right = -1;
        boolean leftTurn = false;

        while (true) {
            if (leftTurn) {
                String leftGem = gems[left++];
                map.put(leftGem, map.get(leftGem) - 1);
                if (map.get(leftGem) == 0) {
                    map.remove(leftGem);
                }
            } else {
                String rightGem = gems[++right];
                map.put(rightGem, map.getOrDefault(rightGem, 0) + 1);
            }

            if (map.size() < set.size()) {
                leftTurn = false;
                if (right == gems.length - 1) return answer;
            } else if (map.size() == set.size()) {
                leftTurn = true;
                if (answer[1] - answer[0] > right - left) {
                    answer = new int[] {left + 1, right + 1};
                }
            }
        }
    }
}
