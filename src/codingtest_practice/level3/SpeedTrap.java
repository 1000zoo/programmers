//https://school.programmers.co.kr/learn/courses/30/lessons/42884
//2023-01-23
//단속카메라

package codingtest_practice.level3;

import java.util.*;

public class SpeedTrap {

    //참조 : https://school.programmers.co.kr/questions/42373
    public int solution(int[][] routes) {
        int answer = 0;

        //참조 : https://ifuwanna.tistory.com/328 (람다로 다시 수정)
        Arrays.sort(routes, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int prev = Integer.MIN_VALUE;

        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            if (prev < start) {
                answer++;
                prev = end;
            }
            if (prev > end) {
                prev = end;
            }
        }

        return answer;
    }
}
