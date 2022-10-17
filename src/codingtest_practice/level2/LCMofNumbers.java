//https://school.programmers.co.kr/learn/courses/30/lessons/12953
//2022-10-17
//N 개의 최소공배수
package codingtest_practice.level2;

import java.util.LinkedList;

public class LCMofNumbers {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
    private int lcm(int n, int m) {
        int res = 1;
        LinkedList<Integer> nList = getDivisor(n);
        LinkedList<Integer> mList = getDivisor(m);

        while (!nList.isEmpty() && !mList.isEmpty()) {
            int nt = nList.peek();
            int mt = mList.peek();
            if (nt == mt) {
                res *= nt;
                nList.poll();
                mList.poll();
            } else if (nt > mt) {
                res *= mt;
                mList.poll();
            } else {
                res *= nt;
                nList.poll();
            }
        }
        while (!nList.isEmpty()) {
            res *= nList.poll();
        }
        while (!mList.isEmpty()) {
            res *= mList.poll();
        }
        return res;
    }

    private LinkedList<Integer> getDivisor(int num) {
        LinkedList<Integer> res = new LinkedList<>();
        int d = 2;
        while (num != 1) {
            if (num % d == 0) {
                res.add(d);
                num /= d;
            } else {
                d++;
            }
        }
        if (res.size() == 0) {
            res.add(1);
        }
        return res;
    }
}
