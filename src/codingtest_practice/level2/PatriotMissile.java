//2023-04-13
//https://school.programmers.co.kr/learn/courses/30/lessons/181188
//요격 시스템

package codingtest_practice.level2;

import java.util.*;

public class PatriotMissile {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int end = 0;

        for (int[] t : targets) {
            int ns = t[0], ne = t[1];
            if (ns < end) {
                end = ne;
                answer++;
            } else {
                end = Math.min(end, ne);
            }
        }

        return answer;
    }
}
