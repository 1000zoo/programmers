//https://school.programmers.co.kr/learn/courses/30/lessons/138476
//2022-12-10
//귤고르기

package codingtest_practice.level2;

import java.util.*;

public class ChooseTangerine {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> sizeMap = new HashMap<>();
        for (int s : tangerine) {
            sizeMap.put(s, sizeMap.getOrDefault(s, 0) + 1);
        }
        List<Integer> keyList = new ArrayList<>(sizeMap.keySet());
        keyList.sort((i1, i2) -> sizeMap.get(i2).compareTo(sizeMap.get(i1)));

        for (int key : keyList) {
            answer++;
            k -= sizeMap.get(key);
            if (k <= 0) break;
        }

        return answer;
    }
}
