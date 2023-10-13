//2023-10-13
//https://school.programmers.co.kr/learn/courses/30/lessons/42892
//길찾기 게임

package codingtest_practice.level3;

import java.util.*;

public class PreorderAndPostorderGame {

    private static class Node implements Comparable {
        public int num;
        public int x;
        public int y;
        public Node left;
        public Node right;

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Object o) {
            Node node = (Node) o;
            if (this.y == node.y) {
                return this.x - node.x;
            }
            return node.y - this.y;
        }
    }

    private Map<Integer, Node> map;
    private List<Integer> key;
    private List<Integer> preorderList;
    private List<Integer> postorderList;

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        preorderList = new ArrayList<>();
        postorderList = new ArrayList<>();

        initMap(nodeinfo);
        setTree();
        Node root = map.get(key.get(0));

        preorder(root);
        postorder(root);

        answer[0] = preorderList.stream().mapToInt(i -> i).toArray();
        answer[1] = postorderList.stream().mapToInt(i -> i).toArray();

        return answer;
    }

    private void preorder(Node node) {
        preorderList.add(node.num);
        if (node.left != null) {
            preorder(node.left);
        }
        if (node.right != null) {
            preorder(node.right);
        }
    }

    private void postorder(Node node) {
        if (node.left != null) {
            postorder(node.left);
        }
        if (node.right != null) {
            postorder(node.right);
        }
        postorderList.add(node.num);
    }

    private void setTree() {
        Queue<Integer> queue = new LinkedList<>(key);
        Node root = map.get(queue.poll());

        while (!queue.isEmpty()) {
            int k = queue.poll();
            Node node = map.get(k);
            Node curr = root;

            while (true) {
                if (node.x < curr.x) {
                    if (curr.left == null) {
                        curr.left = node;
                        break;
                    }
                    curr = curr.left;
                }

                if (curr.x < node.x) {
                    if (curr.right == null) {
                        curr.right = node;
                        break;
                    }
                    curr = curr.right;
                }
            }
        }
    }

    private void initMap(int[][] nodeinfo) {
        map = new HashMap<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            int[] node = nodeinfo[i];

            map.put(i + 1, new Node(i + 1, node[0], node[1]));
        }
        key = new ArrayList<>(map.keySet());

        key.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));
    }
}
