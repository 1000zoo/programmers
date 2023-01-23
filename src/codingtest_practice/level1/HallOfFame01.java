//https://school.programmers.co.kr/learn/courses/30/lessons/138477
//2023-01-23
//명예의 전당 (1)

package codingtest_practice.level1;

import java.util.*;

public class HallOfFame01 {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> fame = new PriorityQueue<>();
        for (int s : score) {
            fame.add(s);
            if (fame.size() > k) {
                fame.poll();
            }
            answer.add(fame.peek());
        }
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
