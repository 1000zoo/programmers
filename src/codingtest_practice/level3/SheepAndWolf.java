//2023-10-23
//https://school.programmers.co.kr/learn/courses/30/lessons/92343
//양과 늑대

package codingtest_practice.level3;

import java.util.*;

public class SheepAndWolf {

    private class Node {
        public int type;
        public List<Node> child;

        public Node(int type) {
            this.type = type;
            this.child = new ArrayList<>();
        }

        public void addChild(Node c) {
            child.add(c);
        }
        public boolean isSheep() {
            return type == 0;
        }
    }

    private Node[] nodes;

    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        nodes = new Node[info.length];
        setNodes(info, edges);
        return dfs(0, 0, nodes[0], nodes[0].child);
    }

    private int dfs(int sheep, int wolf, Node curr, List<Node> nextNodes) {
        if (curr.isSheep()) sheep++;
        else wolf++;

        int max = sheep;
        if (sheep <= wolf) return sheep;

        for (int i = 0; i < nextNodes.size(); i++) {
            Node node = nextNodes.get(i);
            List<Node> copy = new ArrayList<>(nextNodes);
            copy.remove(node);
            copy.addAll(node.child);
            max = Math.max(max, dfs(sheep, wolf, node, copy));
        }

        return max;
    }

    private void setNodes(int[] info, int[][] edges) {
        for (int i = 0; i < info.length; i++) {
            nodes[i] = new Node(info[i]);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].addChild(nodes[edge[1]]);
        }
    }
}
