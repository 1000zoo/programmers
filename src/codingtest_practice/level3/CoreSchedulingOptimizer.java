//2023-11-16
//https://school.programmers.co.kr/learn/courses/30/lessons/12920
//선입 선출 스케쥴링

package codingtest_practice.level3;

public class CoreSchedulingOptimizer {

    public int solution(int n, int[] cores) {
        if (n <= cores.length) {
            return n;
        }

        int finish = findFinishTime(n, cores);
        int completedTasks = cores.length;

        for (int core : cores) {
            completedTasks += (finish - 1) / core;
        }

        for (int i = 0; i < cores.length; i++) {
            if (finish % cores[i] == 0) {
                completedTasks++;
                if (completedTasks == n) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    private int findFinishTime(int n, int[] cores) {
        int max = -1;
        for (int core : cores) {
            max = Math.max(core, max);
        }

        int left = 1;
        int right = max * n;

        while (left < right) {
            int mid = (left + right) / 2;
            int count = cores.length;
            for (int core : cores) {
                count += mid / core;
            }

            if (count >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
