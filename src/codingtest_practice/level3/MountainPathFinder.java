//2023-10-31
//https://school.programmers.co.kr/learn/courses/30/lessons/118669
//등상코스 정하기

package codingtest_practice.level3;

import java.util.*;

public class MountainPathFinder {
    Map<Integer, List<List<Integer>>> graph;
    Set<Integer> gateSet;
    Set<Integer> summitSet;
    Map<Integer, Integer> minIntensityMap;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new HashMap<>();
        gateSet = new HashSet<>();
        summitSet = new HashSet<>();
        minIntensityMap = new HashMap<>();

        initMap(paths);
        initSet(gateSet, gates);
        initSet(summitSet, summits);

        int[] answer = {-1, Integer.MAX_VALUE};

        for (int gate : gates) {
            dfs(gate, -1, answer, new HashSet<>(Arrays.asList(gate)));
        }

        return answer;
    }

    private void dfs(int curr, int intensity, int[] answer, Set<Integer> visited) {
        if (summitSet.contains(curr)) {
            updateAnswer(curr, intensity, answer);
        }

        List<List<Integer>> nextNodes = graph.get(curr);

        for (List<Integer> node : nextNodes) {
            int n = node.get(0);
            int w = node.get(1);

            if (visited.contains(n) || gateSet.contains(n)) continue;

            int newIntensity = Math.max(intensity, w);

            if (minIntensityMap.containsKey(n) && minIntensityMap.get(n) <= newIntensity) {
                continue;
            }

            minIntensityMap.put(n, newIntensity);
            Set<Integer> newVisited = new HashSet<>(visited);
            newVisited.add(n);
            dfs(n, newIntensity, answer, newVisited);
        }
    }

    private void updateAnswer(int summit, int intensity, int[] answer) {
        if (answer[1] > intensity) {
            answer[0] = summit;
            answer[1] = intensity;
        } else if (answer[1] == intensity) {
            answer[0] = Math.min(summit, answer[0]);
        }
    }

    private void initMap(int[][] paths) {
        for (int[] path : paths) {
            int n1 = path[0];
            int n2 = path[1];
            int w = path[2];

            graph.computeIfAbsent(n1, k -> new ArrayList<>()).add(List.of(n2, w));
            graph.computeIfAbsent(n2, k -> new ArrayList<>()).add(List.of(n1, w));
        }
    }

    private void initSet(Set<Integer> set, int[] array) {
        for (int arr : array) {
            set.add(arr);
        }
    }
}
