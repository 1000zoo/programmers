package codingtest_practice.level3;

import java.util.*;

public class NightShiftIndices {

    //solution1
    //priority queue 를 이용한 풀이
    //효율성 테스트 실패 ==> 리턴할 때 stream 을 사용해서
    //               ==> 일일히 제곱하여 더해주면 효율성 테스트 성공
    public long solution1(int n, int[] works) {
        if (Arrays.stream(works).sum() <= n) return 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        for (int i = 0; i < n; i++) {
            pq.offer(pq.poll() - 1);
        }

        return pq.stream().map(i -> (int) Math.pow(i, 2))
                .mapToInt(i -> i).sum();
    }
}
