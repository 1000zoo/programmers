//2023-09-21
//https://school.programmers.co.kr/learn/courses/30/lessons/42861
//섬 연결하기

package codingtest_practice.level3;

import java.util.*;

public class ConnectIslands {

    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> o2[2] - o1[2]);
        Set<Integer> set = new HashSet<>(); //index set

        for (int i = 0; i < costs.length; i++) set.add(i);

        for (int i = 0; i < costs.length; i++) {
            set.remove(i);
            if (!isAllConnected(costs, set, n)) set.add(i);
        }

        for (int i : set) answer += costs[i][2];

        return answer;
    }

    private boolean isAllConnected(int[][] costs, Set<Integer> set, int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        q.add(costs[0][0]);
        visit.add(costs[0][0]); // 첫 번째 첫 섬

        for (int i : set) {
            int s = costs[i][0];
            int e = costs[i][1];
            if (!map.containsKey(s)) map.put(s, new ArrayList<>());
            if (!map.containsKey(e)) map.put(e, new ArrayList<>());

            map.get(s).add(e);
            map.get(e).add(s);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (!map.containsKey(curr)) {
                break;
            }
            for (int next : map.get(curr)) {
                if (!visit.contains(next)) {
                    q.add(next);
                    visit.add(next);
                }
            }
        }

        return n == visit.size();
    }
}
