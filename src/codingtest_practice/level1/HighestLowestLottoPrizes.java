//https://school.programmers.co.kr/learn/courses/30/lessons/77484#
//2022-11-14
//로또의 최고 순위와 최저 순위

package codingtest_practice.level1;

import java.util.*;

public class HighestLowestLottoPrizes {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        Set<Integer> mine = new HashSet<>();
        Set<Integer> win = new HashSet<>();
        for (int i = 0; i < lottos.length; i++) {
            mine.add(lottos[i]);
            win.add(win_nums[i]);
        }
        if (!mine.contains(0)) {
            int t = prizeTier(mine, win);
            return new int[] {Math.min(t, 6), Math.min(t, 6)};
        }
        mine.remove(0);
        Set<Integer> union = new HashSet<>(mine);
        union.addAll(win);
        int max = union.size() - win.size() + 1;
        int min = Math.min(union.size() - mine.size() + 1, 6);


        return new int[] {max, min};
    }

    private int prizeTier(Set<Integer> mine, Set<Integer> win) {
        Set<Integer> union = mine;
        union.addAll(win);
        return union.size() - win.size() + 1;
    }
}
