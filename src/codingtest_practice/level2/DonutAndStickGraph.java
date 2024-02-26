//2024-02-26
//https://school.programmers.co.kr/learn/courses/30/lessons/258711?language=java
//도넛과 막대 그래프

package codingtest_practice.level2;
import java.util.*;

class DonutAndStickGraph {

    private Map<Integer, List<Integer>> graph;
    private Set<Integer> visited;
    private int[] answer;

    public int[] solution(int[][] edges) {
        answer = new int[4];
        init(edges);
        traversal();
        return answer;
    }

    private void traversal() {
        for (int node : graph.get(answer[0])) {
            boolean[] info = {false, false};    // 같은 곳을 또 방문했는 지, 간선이 두개 이상인지
            dfs(node, info);

            if (info[0] && !info[1]) {
                answer[1]++;
            } else if (info[0]) {
                answer[3]++;
            } else {
                answer[2]++;
            }
        }
    }

    private void dfs(int curr, boolean[] info) {
        if (visited.contains(curr)) {
            info[0] = true;
            return;
        }
        visited.add(curr);

        if (!graph.containsKey(curr)) {
            return;
        }
        if (graph.get(curr).size() > 1) info[1] = true;

        for (int node : graph.get(curr)) {
            dfs(node, info);
        }
    }

    private void init(int[][] edges) {
        graph = new HashMap<>();
        Map<Integer, Integer> inCount = new HashMap<>();
        visited = new HashSet<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            inCount.put(to, inCount.getOrDefault(to, 0) + 1);
            graph.get(from).add(to);
        }

        int max = 0;
        for (int node : graph.keySet()) {
            if (!inCount.containsKey(node) && graph.get(node).size() > max) {
                answer[0] = node;
                max = graph.get(node).size();
            }
        }
    }
}