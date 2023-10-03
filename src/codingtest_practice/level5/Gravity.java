//2023-10-03
//https://school.programmers.co.kr/learn/courses/30/lessons/77887
//중력 작용

package codingtest_practice.level5;

import java.util.*;

// 기본적인 트리 알고리즘으로 풀려고 했으나, 35 개 중, 5개의 테스트 케이스에서 시간초과
// 시간 복잡도: 균형잡힌 경우 O(Q * logN), 불균형인 경우 O(Q * N)
public class Gravity {

    private class Tree {
        public int nodeNumber;
        public int val;
        public long sum;

        public Tree parent;
        public List<Tree> children;

        public Tree(int nodeNumber, int val) {
            this.nodeNumber = nodeNumber;
            this.val = val;
            this.sum = 0L;
            this.parent = null;
            this.children = new ArrayList<>();
        }

        public void setSum(long sum) {
            this.sum = sum;
        }
        public void switchWithParent(int w, int removedValue) {
            if (this.parent == null) {
                this.val = w;
                this.setSum(this.sum - removedValue + this.val);
                return;
            }

            int temp = this.parent.val;
            this.parent.val = this.val;
            this.val = temp;
            this.setSum(this.sum - removedValue + this.val);
            this.parent.switchWithParent(w, removedValue);
        }
    }

    public long[] solution(int[] values, int[][] edges, int[][] queries) {
        List<Long> list = new ArrayList<>();
        Map<Integer, Tree> treeMap = initTreeMap(values, edges);
        Tree root = treeMap.get(1);
        setNodesSum(root);

        for (int[] query : queries) {
            if (query[1] == -1) {
                list.add(treeMap.get(query[0]).sum);
            } else {
                Tree temp = treeMap.get(query[0]);
                temp.switchWithParent(query[1], temp.val);
            }
        }

        return list.stream().mapToLong(l -> l).toArray();
    }

    private long setNodesSum(Tree root) {
        if (root == null) return 0L;

        long sum = root.val;

        for (Tree node : root.children) {
            sum += setNodesSum(node);
        }
        root.setSum(sum);

        return sum;
    }

    private Map<Integer, Tree> initTreeMap(int[] values, int[][] edges) {
        Map<Integer, Tree> nodeMap = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            nodeMap.put(i + 1, new Tree(i + 1, values[i]));
        }

        HashMap<Integer, List<Integer>> parentMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            parentMap.putIfAbsent(a, new ArrayList<>());
            parentMap.putIfAbsent(b, new ArrayList<>());

            parentMap.get(a).add(b);
            parentMap.get(b).add(a);
        }

        constructTree(visited, parentMap, nodeMap);

        return nodeMap;
    }
    private void constructTree(HashSet<Integer> visited, Map<Integer, List<Integer>> parentMap, Map<Integer, Tree> nodeMap) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            int currentNodeNumber = stack.pop();

            if (visited.contains(currentNodeNumber)) {
                continue;
            }

            visited.add(currentNodeNumber);
            Tree currentNode = nodeMap.get(currentNodeNumber);

            for (int neighbor : parentMap.getOrDefault(currentNodeNumber, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    Tree childNode = nodeMap.get(neighbor);
                    currentNode.children.add(childNode);
                    childNode.parent = currentNode;
                    stack.push(neighbor);
                }
            }
        }
    }
}
