//2023-09-07
//https://school.programmers.co.kr/learn/courses/30/lessons/131130
//혼자 놀기 달인

package codingtest_practice.level2;

import java.util.*;

public class SoloPlayer {

    public int solution(int[] cards) {
        int currNum = 1;
        boolean[] appear = new boolean[cards.length + 1];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sizeList = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) map.put(i + 1, cards[i]);

        while (currNum != 0) {
            int size = 0;

            while (!appear[currNum]) {
                size++;
                appear[currNum] = true;
                currNum = map.get(currNum);
            }
            sizeList.add(size);
            currNum = getNextNum(appear);
        }
        if (sizeList.size() == 1) return 0;

        sizeList.sort(Collections.reverseOrder());

        return sizeList.get(0) * sizeList.get(1);
    }

    private int getNextNum(boolean[] appear) {
        for (int i = 1; i < appear.length; i++) {
            if (!appear[i]) return i;
        }
        return 0;
    }
}
