//2023-09-30
//https://school.programmers.co.kr/learn/courses/30/lessons/43238
//입국 심사

package codingtest_practice.level3;

import java.util.*;

public class EntryScreening {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long maxTime = (long) n * times[times.length - 1];
        long minTime = 1;

        while (minTime < maxTime) {
            long avg = (minTime + maxTime) / 2;
            long temp = 0;

            for (int time : times) {
                temp += avg / time;
                if (temp >= n) break;
            }

            if (temp < n) {
                minTime = avg + 1;
            } else {
                maxTime = avg;
            }
        }

        return maxTime;
    }
}
