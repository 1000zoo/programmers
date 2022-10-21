//https://school.programmers.co.kr/learn/courses/30/lessons/42628
//2022-10-22
//이중우선순위큐

package codingtest_practice.level3;

public class DoublePriorityQueue {
    class MyList {
    public int val;
    public MyList next;

    public MyList(int val) {
        this.val = val;
    }
    public MyList(int val, MyList next) {
        this.val = val;
        this.next = next;
    }
}

    MyList queue = new MyList(-1);
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for (String operation : operations) {
            int m = menu(operation);
            if (m == 0) {
                add(toInt(operation));
            } else if (m == 1 && queue.next != null) {
                getMax();
            } else if (m == 2 && queue.next != null) {
                getMin();
            } else {
                System.out.println("error");
            }
        }
        if (queue.next != null) {
            answer[0] = getMax();
            answer[1] = getMin();
        }
        return answer;
    }

    private int toInt(String s) {
        if (s.charAt(0) == 'I') {
            return Integer.parseInt(s.substring(2));
        } else {
            return -1;
        }
    }

    private void add(int num) {
        MyList curr = queue;
        while (curr.next != null) {
            if (curr.next.val >= num) {
                curr.next = new MyList(num, curr.next);
                return;
            }
            curr = curr.next;
        }
        curr.next = new MyList(num);
    }

    private int getMin() {
        MyList curr = queue;
        int min = curr.next.val;
        curr.next = curr.next.next;
        return min;
    }
    private int getMax() {
        MyList curr = queue;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        int max = curr.next.val;
        curr.next = null;
        return max;
    }

    private int menu(String operation) {
        if (operation.contains("I")) {
            return 0;
        }
        if (operation.equals("D 1")) {
            return 1;
        } else if (operation.equals("D -1")) {
            return 2;
        }
        return -1;
    }
}
