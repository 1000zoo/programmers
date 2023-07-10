//2023-07-10
//https://school.programmers.co.kr/learn/courses/30/lessons/132265
//롤케이크 자르기

package codingtest_practice.level2;

import java.util.*;

public class CutRollCake {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        int[] a1 = new int[topping.length];
        int[] a2 = new int[topping.length];

        for (int i = 0; i < topping.length; i++) {
            s1.add(topping[i]);
            s2.add(topping[topping.length - 1 - i]);
            a1[i] = s1.size();
            a2[topping.length - 1 - i] = s2.size();
        }

        for (int i = 0; i < topping.length - 1; i++) {
            if (a1[i] == a2[i + 1]) answer++;
        }

        return answer;
    }
}
