//2023-09-01
//https://school.programmers.co.kr/learn/courses/30/lessons/64062?language=java
//징검다리 건너기

package codingtest_practice.level3;

import java.util.*;

public class CrossSteppingStones {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<int[]> dq = new LinkedList<>();

        for (int i = 0; i < stones.length; i++) {
            while (!dq.isEmpty() && dq.peekLast()[1] < stones[i]) dq.removeLast();
            dq.addLast(new int[] {i, stones[i]});

            if (i - dq.getFirst()[0] >= k) dq.removeFirst();
            if (i >= k - 1) answer = Math.min(answer, dq.getFirst()[1]);
        }

        return answer;
    }
}
