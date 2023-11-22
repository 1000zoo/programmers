//2023-09-01 (새로운 풀이: 2023-11-22)
//https://school.programmers.co.kr/learn/courses/30/lessons/64062?language=java
//징검다리 건너기

package codingtest_practice.level3;

import java.util.*;

public class CrossSteppingStones {

    // 이진탐색
    public int solution(int[] stones, int k) {
        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isValid(stones, mid, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean isValid(int[] origin, int mid, int k) {
        int count = 0;
        int[] stones = origin.clone();
        for (int i = 0; i < stones.length; i++) {
            stones[i] -= mid;
            if (stones[i] < 0) count++;
            else count = 0;
            if (count >= k) return false;
        }

        return true;
    }

    // ========================================================

    // Sliding Window 적용 풀이
    public int oldSolution(int[] stones, int k) {
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
