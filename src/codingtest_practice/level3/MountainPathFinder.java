//2023-10-31 (새로운 풀이: 2023-11-22)
//https://school.programmers.co.kr/learn/courses/30/lessons/118669
//등상코스 정하기

package codingtest_practice.level3;

import java.util.*;

public class MountainPathFinder {

    private Map<Integer, List<int[]>> graph;
    private Set<Integer> gateSet;
    private Set<Integer> summitSet;
    private int top = -1;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int left = 0;
        int right = initGraphAndGetMaxWeight(n, paths);
        initSet(gates, summits);

        while (left <= right) {
            int mid = (left + right) / 2;

            if (bfs(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[] {top, left};
    }

    private boolean bfs(int maxIntensity) {
        int summit = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (int gate : gateSet) {
            queue.add(gate);
            visited.add(gate);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int[] next : graph.get(curr)) {
                int nextPoint = next[0];
                int weight = next[1];

                if (maxIntensity < weight
                        || visited.contains(nextPoint)
                        || gateSet.contains(nextPoint)) continue;

                visited.add(nextPoint);

                if (summitSet.contains(nextPoint)) {
                    summit = Math.min(summit, nextPoint);
                    continue;
                }

                queue.add(nextPoint);
            }

        }
        if (summit != Integer.MAX_VALUE) {
            top = summit;
            return true;
        }
        return false;
    }

    private void initSet(int[] gates, int[] summits) {
        gateSet = new HashSet<>();
        summitSet = new HashSet<>();

        for (int gate : gates) {
            gateSet.add(gate);
        }
        for (int summit : summits) {
            summitSet.add(summit);
        }

    }

    private int initGraphAndGetMaxWeight(int n, int[][] paths) {
        int weight = 0;
        graph = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] path : paths) {
            weight = Math.max(weight, path[2]);
            graph.get(path[0]).add(new int[] {path[1], path[2]});
            graph.get(path[1]).add(new int[] {path[0], path[2]});
        }

        return weight;
    }
}
