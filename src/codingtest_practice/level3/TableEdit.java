//2023-10-11
//https://school.programmers.co.kr/learn/courses/30/lessons/81303
//표 편집

package codingtest_practice.level3;

import java.util.*;

class TableEdit {

    private class Node {
        public int n;
        public Node up;
        public Node down;

        public Node(int n) {
            this.n = n;
        }
        public Node(int n, Node up, Node down) {
            this.n = n;
            this.up = up;
            this.down = down;
        }
        public void setUp(Node up) {
            this.up = up;
        }
        public void setDown(Node down) {
            this.down = down;
        }
        public void removeThis() {
            if (this.up != null) {
                this.up.setDown(this.down);
            }
            if (this.down != null) {
                this.down.setUp(this.up);
            }
        }
        public void undo() {
            if (this.up != null) {
                this.up.setDown(this);
            }
            if (this.down != null) {
                this.down.setUp(this);
            }
        }
    }

    private Node curr;
    private Node first;
    private Stack<Node> removedStack;

    public String solution(int n, int k, String[] cmd) {
        init(n, k);

        for (String c : cmd) {
            decodeCmd(c);
        }

        return toString(n);
    }

    private void print() {
        Node temp = first;

        while (temp != null) {
            System.out.print(temp.n + " -> ");
            temp = temp.down;
        }
        System.out.println("(" + curr.n + ")");

    }

    private void decodeCmd(String cmd) {
        char option = cmd.charAt(0);

        if (option == 'U') {
            up(cmd.charAt(2) - '0');
            return;
        }
        if (option == 'D') {
            down(cmd.charAt(2) - '0');
            return;
        }
        if (option == 'C') {
            remove();
            return;
        }
        undo();
    }

    private void up(int n) {
        while (n-- > 0) {
            curr = curr.up;
        }
    }
    private void down(int n) {
        while (n-- > 0) {
            curr = curr.down;
        }
    }
    private void remove() {
        curr.removeThis();
        removedStack.push(curr);
        if (curr.down == null) {
            curr = curr.up;
            return;
        }
        curr = curr.down;
    }
    private void undo() {
        removedStack.pop().undo();
    }

    private String toString(int n) {
        StringBuilder sb = new StringBuilder();
        Node temp = first;
        boolean[] list = new boolean[n];

        while (temp != null) {
            list[temp.n] = true;
            temp = temp.down;
        }

        for (boolean tf : list) {
            sb.append(tf ? "O" : "X");
        }

        return sb.toString();
    }

    private void init(int n, int k) {
        setLinkedList(n, k);
        removedStack = new Stack<>();
    }

    private void setLinkedList(int n, int k) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        nodes[0].setDown(nodes[1]);
        for (int i = 1; i < n - 1; i++) {
            nodes[i].setUp(nodes[i - 1]);
            nodes[i].setDown(nodes[i + 1]);
        }
        nodes[n - 1].setUp(nodes[n - 2]);

        curr = nodes[k];
        first = nodes[0];
    }
}