//2023-12-04
//https://school.programmers.co.kr/learn/courses/30/lessons/92345
//사라지는 발판

package codingtest_practice.level3;

import java.util.*;

public class DisappearSquareGame {

    private static class Square {
        private final int x;
        private final int y;

        public Square(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Square(int[] curr) {
            this.x = curr[0];
            this.y = curr[1];
        }

        public int[] getXY() {
            return new int[] {x, y};
        }

        public Square nextSquare(int[] dir) {
            return new Square(x + dir[0], y + dir[1]);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Square other = (Square) o;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    private static class Node {
        private List<Node> children;
        private final Square square;
        private int reward;     // win: 1 * minTotalSize, lose: -1 * maxTotalSize
        private int depth;

        public Node() {
            this.children = new ArrayList<>();
            square = new Square(new int[]{-1, -1});
        }

        public Node(Square square, int depth) {
            this.square = square;
            this.children = new ArrayList<>();
            this.reward = 0;
            this.depth = depth;
        }

        public Square getSquare() {
            return square;
        }

        public int depth() {
            return depth;
        }

        public Square nextSquare(int[] dir) {
            return square.nextSquare(dir);
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public void setReward() {
            this.reward = depth;
        }

        public void pickReward() {
            if (children.isEmpty()) {
                return;
            }
            int reward = -1;
            for (Node child : children) {
                int childReward = child.getReward();
                if (childReward > 0 && reward > 0) {
                    reward = Math.min(reward, childReward);
                } else if (childReward > 0) {
                    reward = childReward;
                } else if (childReward < 0 && reward < 0) {
                    reward = Math.min(childReward, reward);
                }
            }
            this.reward = -reward;
        }

        public int getReward() {
            return reward;
        }

        @Override
        public String toString() {
            return square.toString() + ": " + ", depth: " + depth + ", reward: " + reward;
        }
    }

    private final static int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int[][] map;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        if (board.length * board[0].length == 1) {
            return 0;
        }
        int answer = -1;
        map = board;

        Square a = new Square(aloc);
        Square b = new Square(bloc);

        Node A = new Node(a, 0);
        Node B = new Node(b, 0);

        Set<Square> disappeared = new HashSet<>();
        List<Node> nodes = new ArrayList<>();

        disappeared.add(a);

        Node node = new Node();

        for (int[] dir : dirs) {
            Square nextSquare = A.nextSquare(dir);
            if (!isWithinBoundary(nextSquare) || isWall(nextSquare)) {
                continue;
            }
            Node temp = new Node(nextSquare, 1);
            dfs(temp, B, disappeared);
            nodes.add(temp);
        }

        node.setChildren(nodes);
        node.pickReward();

        return Math.abs(node.getReward());
    }

    private void dfs(Node currPlayer, Node nextPlayer, Set<Square> disappeared) {
        Square square = currPlayer.getSquare();
        Square nextPlayerSquare = nextPlayer.getSquare();

        if (disappeared.contains(nextPlayerSquare)) {
            currPlayer.setReward();
            return;
        }
        List<Node> list = new ArrayList<>();

        for (int[] dir : dirs) {
            Square nextSquare = nextPlayerSquare.nextSquare(dir);
            if (!isWithinBoundary(nextSquare) || disappeared.contains(nextSquare) || isWall(nextSquare)) {
                continue;
            }
            Node temp = new Node(nextSquare, currPlayer.depth() + 1);
            list.add(temp);
            disappeared.add(nextPlayerSquare);
            dfs(temp, currPlayer, disappeared);
            disappeared.remove(nextPlayerSquare);
        }

        if (list.isEmpty()) {
            currPlayer.setReward();
            return;
        }

        currPlayer.setChildren(list);
        currPlayer.pickReward();
    }

    private boolean isWall(Square square) {
        int[] curr = square.getXY();
        return map[curr[0]][curr[1]] == 0;
    }

    private boolean isWithinBoundary(Square square) {
        int[] curr = square.getXY();
        return 0 <= curr[0] && curr[0] < map.length && 0 <= curr[1] && curr[1] < map[0].length;
    }
}
