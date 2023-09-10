package codingtest_practice.level2;

import java.util.*;

public class DefenceGame {

    public int solution(int n, int k, int[] enemy) {
        if (k <= 0) return -1;
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            if (pq.size() > k) n -= pq.poll();
            if (n  < 0) return i;
        }

        return enemy.length;
    }
}
