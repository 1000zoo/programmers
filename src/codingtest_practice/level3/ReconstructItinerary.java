//2023-09-22
//https://school.programmers.co.kr/learn/courses/30/lessons/43164#
//여행 경로

package codingtest_practice.level3;

import java.util.*;

public class ReconstructItinerary {

    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] t : tickets) {
            if (!map.containsKey(t[0])) map.put(t[0], new PriorityQueue<>());
            map.get(t[0]).add(t[1]);
        }

        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        while (!stack.isEmpty()) {
            String current = stack.peek();
            if (map.containsKey(current) && !map.get(current).isEmpty()) {
                stack.push(map.get(current).poll());
            } else {
                answer.add(0, stack.pop());
            }
        }

        return answer.toArray(new String[0]);
    }
}
