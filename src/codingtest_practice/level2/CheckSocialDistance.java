//2023-09-03
//https://school.programmers.co.kr/learn/courses/30/lessons/81302#
//사회적 거리두기

package codingtest_practice.level2;

import java.util.*;

public class CheckSocialDistance {

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkRoom(String[] place) {
        Map<Character, List<int[]>> map = initMap(place);
        List<int[]> pList = map.get('P');

        for (int i = 0; i < pList.size() - 1; i++) {
            for (int j = i + 1; j < pList.size(); j++) {
                int[] t1 = pList.get(i);
                int[] t2 = pList.get(j);

                if (!isOver2(t1, t2) &&
                        !checkPartition(t1, t2, map.get('X'))) return false;
            }
        }

        return true;
    }

    private boolean isOver2(int[] t1, int[] t2) {
        return Math.abs(t2[0] - t1[0]) + Math.abs(t2[1] - t1[1]) > 2;
    }

    private boolean checkPartition(int[] t1, int[] t2, List<int[]> xList) {
        int[] c1, c2;
        if (t1[0] == t2[0]) {
            c1 = new int[] {t1[0], (t1[1] + t2[1]) / 2};
            c2 = new int[] {t1[0], (t1[1] + t2[1]) / 2};
        } else if (t1[1] == t2[1]) {
            c1 = new int[] {(t1[0] + t2[0]) / 2, t1[1]};
            c2 = new int[] {(t1[0] + t2[0]) / 2, t1[1]};
        }
        else {
            c1 = new int[] {t1[0], t2[1]};
            c2 = new int[] {t2[0], t1[1]};
        }

        boolean l = false;
        boolean r = false;

        for (int[] x : xList) {
            if (equals(c1, x)) l = true;
            if (equals(c2, x)) r = true;
        }

        return l && r;
    }

    private boolean equals(int[] t1, int[] t2) {
        return t1[0] == t2[0] && t1[1] == t2[1];
    }

    private Map<Character, List<int[]>> initMap(String[] place) {
        Map<Character, List<int[]>> map = new HashMap<>();

        map.put('P', new ArrayList<>());
        map.put('X', new ArrayList<>());
        map.put('O', new ArrayList<>());

        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                map.get(place[i].charAt(j)).add(new int[] {i, j});
            }
        }

        return map;
    }
}
