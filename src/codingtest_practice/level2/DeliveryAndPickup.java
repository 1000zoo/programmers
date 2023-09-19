//2023-09-19
//https://school.programmers.co.kr/learn/courses/30/lessons/150369#
//택배 배달과 수거하기

package codingtest_practice.level2;

public class DeliveryAndPickup {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = 0;
        int p = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while (d < deliveries[i] || p < pickups[i]) {
                    cnt++;
                    d += cap;
                    p += cap;
                }
                d -= deliveries[i];
                p -= pickups[i];
                answer += ((long) (i + 1) * cnt * 2);
            }
        }

        return answer;
    }

    // 시간 초과
    public long wrongSolution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        for (int i = n - 1; i >= 0;) {
            int del = deliveries[i];
            int pick = pickups[i];

            int distance = (i + 1) * 2;
            if (del == 0 && pick == 0) {
                i--;
                continue;
            }

            int heavy = Math.max(del, pick);
            int r = heavy % cap != 0 ? (heavy / cap) + 1 : heavy / cap; // 왕복 수
            int maxCap = r * cap;

            int d = 0;
            int p = 0;


            int nextIndex = 0;
            while (i >= 0) {
                boolean dStop = false;
                boolean pStop = false;
                if (d + deliveries[i] <= maxCap) {
                    d += deliveries[i];
                    deliveries[i] = 0;
                } else {
                    nextIndex = Math.max(nextIndex, i);
                    deliveries[i] -= (maxCap - d);
                    d = maxCap;
                    dStop = true;
                }
                if (p + pickups[i] <= maxCap) {
                    p += pickups[i];
                    pickups[i] = 0;
                } else {
                    nextIndex = Math.max(nextIndex, i);
                    pickups[i] -= (maxCap - p);
                    p = maxCap;
                    pStop = true;
                }
                if (dStop && pStop) break;
                i--;
            }
            i = nextIndex;

            answer += ((long) distance * r);
        }

        return answer;
    }
}
