//2023-07-25
//https://school.programmers.co.kr/learn/courses/30/lessons/118667
//두 큐의 합을 같게 만들기

package codingtest_practice.level2;

import java.util.*;

class MakeSameSumOfTwoQueue {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = toLL(queue1);
        Queue<Integer> q2 = toLL(queue2);
        long sum1 = sum(q1);
        long sum2 = sum(q2);
        long total = sum1 + sum2;
        int len = q1.size();
        if (total % 2 != 0) return -1;

        int answer = 0;

        for (int i = 0; i <= 3 * len; i++) {
            if (sum1 > sum2) {
                int temp = q1.poll();
                q2.add(temp);
                sum1 -= temp;
                sum2 += temp;
                answer++;
            } else if (sum2 > sum1) {
                int temp = q2.poll();
                q1.add(temp);
                sum1 += temp;
                sum2 -= temp;
                answer++;
            } else {
                break;
            }
        }
        if (sum(q1) != sum(q2)) return -1;

        return answer;
    }

    private Queue<Integer> toLL(int[] queue) {
        Queue<Integer> q = new LinkedList<>();
        for (int a : queue) q.add(a);
        return q;
    }

    private long sum(Queue<Integer> q) {
        long s = 0;
        return q.stream().mapToInt(i->i).sum();
    }
}