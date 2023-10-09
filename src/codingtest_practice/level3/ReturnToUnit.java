//2023-10-09
//https://school.programmers.co.kr/learn/courses/30/lessons/132266
//부대복귀

package codingtest_practice.level3;

import java.util.*;

public class ReturnToUnit {


    private Map<Integer, Node> nodeMap;

    private static class Node {
        public int num;
        public List<Node> neighbor;

        public Node(int n) {
            num = n;
            neighbor = new ArrayList<>();
        }

        public void addNeighbor(Node node) {
            neighbor.add(node);
        }

    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        setNodeMap(n);
        setConnections(roads);
        int[] costs = getCosts(destination);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = costs[sources[i]];
        }

        return answer;
    }

    private int[] getCosts(int dest) {
        Queue<Node> q = new LinkedList<>();
        Node curr = nodeMap.get(dest);
        int[] dp = new int[nodeMap.size() + 1];
        Arrays.fill(dp, -1);
        dp[dest] = 0;

        q.add(curr);

        while (!q.isEmpty()) {
            curr = q.poll();
            int currNum = curr.num;

            for (Node node : curr.neighbor) {
                int nodeNum = node.num;

                if (dp[nodeNum] == -1) {
                    dp[nodeNum] = dp[currNum] + 1;
                    q.add(node);
                }
                if (dp[nodeNum] > dp[currNum] + 1) {
                    dp[nodeNum] = dp[currNum] + 1;
                    q.add(node);
                }
            }
        }

        return dp;
    }

    private void setNodeMap(int n) {
        nodeMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodeMap.put(i, new Node(i));
        }
    }

    private void setConnections(int[][] roads) {
        for (int[] road : roads) {
            Node n1 = nodeMap.get(road[0]);
            Node n2 = nodeMap.get(road[1]);

            n1.addNeighbor(n2);
            n2.addNeighbor(n1);
        }
    }
}
