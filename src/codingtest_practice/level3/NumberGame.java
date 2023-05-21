//2023-05-21
//https://school.programmers.co.kr/learn/courses/30/lessons/12987
//숫자 게임

package codingtest_practice.level3;

import java.util.*;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        while (!b.isEmpty()) {
            int ap = a.peek();
            int bp = b.peek();

            if (ap < bp) {
                answer++;
                a.poll();
                b.poll();
            } else {
                b.poll();
            }
        }
        return answer;
    }
}
