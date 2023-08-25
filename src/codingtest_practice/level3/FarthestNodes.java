//2023-08-25
//https://school.programmers.co.kr/learn/courses/30/lessons/49189
//가장 먼 노드

package codingtest_practice.level3;

import java.util.*;

public class FarthestNodes {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] distances = new int[n + 1];
        Set<Integer> visited = new HashSet<>();
        int max = 0;
        distances[1] = 0;
        visited.add(1);

        for (int[] e : edge) {
            List<Integer> temp = map.getOrDefault(e[0], new ArrayList<>());
            temp.add(e[1]);
            map.put(e[0], temp);
            temp = map.getOrDefault(e[1], new ArrayList<>());
            temp.add(e[0]);
            map.put(e[1], temp);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i : map.getOrDefault(curr, new ArrayList<>())) {
                if (i == 0) continue;
                if (!visited.contains(i)) {
                    visited.add(i);
                    distances[i] = distances[curr] + 1;
                    max = Math.max(distances[i], max);
                    q.add(i);
                }
            }
        }

        for (int d : distances) if (d == max) answer++;

        return answer;
    }
}
