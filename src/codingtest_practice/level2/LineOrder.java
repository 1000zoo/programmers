//2023-08-08
//
//줄 서는 방법

package codingtest_practice.level2;

import java.util.*;

public class LineOrder {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int[] answer = new int[n];
        k -= 1;
        int d = n - 1;
        for (int i = 0; i < n; i++) {
            long temp = fact(d--);
            int index = (int) (k / temp);
            answer[i] = list.get(index);
            list.remove(index);
            k %= temp;
        }

        return answer;
    }

    private long fact(int n) {
        if (n <= 1) return 1;
        return (long) n * fact(n - 1);
    }
}
