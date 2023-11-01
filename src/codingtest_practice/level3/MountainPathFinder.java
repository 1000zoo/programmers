//2023-10-31
//https://school.programmers.co.kr/learn/courses/30/lessons/118669
//등상코스 정하기

package codingtest_practice.level3;

import java.util.*;

public class MountainPathFinder {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    Set<Integer> gateSet = new HashSet<>();
    Set<Integer> summitSet = new HashSet<>();
    int top = -1;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for (int[] path : paths) {
            graph.computeIfAbsent(path[0], k -> new ArrayList<>()).add(new int[]{path[1], path[2]});
            graph.computeIfAbsent(path[1], k -> new ArrayList<>()).add(new int[]{path[0], path[2]});
        }
        for (int gate : gates) {
            gateSet.add(gate);
        }
        for (int summit : summits) {
            summitSet.add(summit);
        }

        int l = 1;
        int r = 10000000;

        while (l <= r) {
            int m = (l + r) / 2;
            if (bfs(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return new int[]{top, l};
    }

    private boolean bfs(int cut) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();

        for (int gate : gateSet) {
            queue.add(gate);
            visited.put(gate, 1);
        }

        int last = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int[] next : graph.getOrDefault(current, new ArrayList<>())) {
                if (next[1] > cut || visited.containsKey(next[0]) || gateSet.contains(next[0])) continue;
                visited.put(next[0], 1);
                if (summitSet.contains(next[0])) {
                    last = Math.min(last, next[0]);
                    continue;
                }
                queue.add(next[0]);
            }
        }

        if (last != Integer.MAX_VALUE) {
            top = last;
            return true;
        }
        return false;
    }
}
