//2023-09-28
//https://school.programmers.co.kr/learn/courses/30/lessons/42885
//구명보트

package codingtest_practice.level2;

import java.util.*;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        Deque<Integer> dq = new LinkedList<>();

        for (int person : people) {
            dq.add(person);
        }

        while (!dq.isEmpty()) {
            int weights = dq.pollLast();
            answer++;
            if (!dq.isEmpty() && weights + dq.peekFirst() <= limit) {
                dq.pollFirst();
            }
        }

        return answer;
    }
}
