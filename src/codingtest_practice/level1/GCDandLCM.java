//https://school.programmers.co.kr/learn/courses/30/lessons/12940
//2022-09-26
//최대공약수와 최소공배수

package codingtest_practice.level1;

import java.util.LinkedList;

public class GCDandLCM {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);
        return answer;
    }

    //greatest common denominator
    private int gcd(int n, int m) {
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
                mList.poll();
            } else {
                nList.poll();
            }
        }

        return res;
    }

    //least common multiple
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
