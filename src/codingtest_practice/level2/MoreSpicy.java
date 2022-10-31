//https://school.programmers.co.kr/learn/courses/30/lessons/42626
//2022-10-31
//더 맵게

package codingtest_practice.level2;

import java.util.*;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sv : scoville) {
            pq.offer(sv);
        }
        while (pq.size() != K) {
            int mix = pq.poll() + pq.poll() * 2;
            pq.offer(mix);
            answer++;
            if (pq.size() == 1 && pq.peek() < K) {
                return -1;
            }
            if (pq.peek() >= K) {
                break;
            }
        }

        return answer;
    }
}
