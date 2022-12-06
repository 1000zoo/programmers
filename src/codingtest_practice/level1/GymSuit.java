//https://school.programmers.co.kr/learn/courses/30/lessons/42862
//2022-12-07
//체육복

package codingtest_practice.level1;

import java.util.*;

public class GymSuit {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> rSet = toSet(reserve);
        Set<Integer> lSet = toSet(lost);

        Set<Integer> retainSet = new HashSet<>(rSet);
        retainSet.retainAll(lSet);


        rSet.removeAll(retainSet);
        lSet.removeAll(retainSet);

        for (int i : rSet) {
            if (lSet.contains(i - 1)) {
                lSet.remove(i - 1);
            } else {
                lSet.remove(i + 1);
            }
        }
        return n - lSet.size();
    }

    private Set<Integer> toSet(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int n : array) {
            set.add(n);
        }
        return set;
    }
}
