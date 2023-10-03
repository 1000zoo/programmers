//2023-10-03
//https://school.programmers.co.kr/learn/courses/30/lessons/42627#
//디스크 컨트롤러

package codingtest_practice.level3;

import java.util.*;

public class DiscController {
    public int solution(int[][] jobs) {
        int answer = 0;
        List<int[]> list = new LinkedList<>(Arrays.asList(jobs));

        list.sort((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int endTime = 0;

        while (!list.isEmpty()) {
            int[] current = getJob(endTime, list);
            int requestTime = current[0];
            int runningTime = current[1];
            int startTime = Math.max(endTime, requestTime);
            endTime = startTime + runningTime;
            answer += endTime - requestTime;
        }

        return answer / jobs.length;
    }

    private int[] getJob(int endTime, List<int[]> list) {
        int[] temp = null;
        int minRunningTime = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            int[] job = list.get(i);
            int requestTime = job[0];
            int runningTime = job[1];

            if (runningTime < minRunningTime && (temp == null || requestTime <= endTime)) {
                minRunningTime = runningTime;
                temp = job;
                minIndex = i;
            }
        }

        return list.remove(minIndex);
    }
}
