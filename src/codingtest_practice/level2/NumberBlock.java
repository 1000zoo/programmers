//2023-09-15
//https://school.programmers.co.kr/learn/courses/30/lessons/12923
//숫자 블록

package codingtest_practice.level2;

import java.util.*;

public class NumberBlock {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin + 1)];
        int b = (int) begin;
        int e = (int) end;

        for (int i = b; i <= e; i++) {
            answer[i - b] = blockNumber(i);
        }

        return answer;
    }

    private int blockNumber(int l) {
        if (l == 1) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 2; i <= Math.sqrt(l); i++) {
            if (l % i == 0) {
                list.add(l / i);
                list.add(i);
            }
        }

        Collections.sort(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= 10000000) return list.get(i);
        }

        return 0;
    }
}
