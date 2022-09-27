//https://school.programmers.co.kr/learn/courses/30/lessons/42583
//2022-09-27
//다리를 지나는 트럭

package codingtest_practice.level2;

import java.util.LinkedList;

public class TruckOnTheBridge {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Integer> q = new LinkedList<>();
        LinkedList<Integer> onTheBridge = new LinkedList<>();
        int time = 0; //answer
        int currWeight = 0;
        for (int i : truck_weights) {
            q.add(i);
        }

        while (!q.isEmpty()) {
            time++;
            if (onTheBridge.size() == bridge_length) {
                if (onTheBridge.isEmpty()) {
                    return -1;
                }
                currWeight -= onTheBridge.poll();
            }
            if (!q.isEmpty() && currWeight + q.peek() <= weight) {
                currWeight += q.peek();
                onTheBridge.add(q.poll());
            } else {
                onTheBridge.add(0);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        solution(2, 10, new int[]{7, 4, 5, 6});
    }
}
