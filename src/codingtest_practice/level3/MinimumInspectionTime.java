//2023-11-16
//https://school.programmers.co.kr/learn/courses/30/lessons/43238
//입국심사

package codingtest_practice.level3;

public class MinimumInspectionTime {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = n * max(times);

        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int time : times) {
                count += mid / time;
            }

            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private long max(int[] times) {
        long maxTime = -1;
        for (int time : times) {
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}
