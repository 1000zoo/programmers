//2023-02-16
//https://school.programmers.co.kr/learn/courses/30/lessons/154538
//숫자 변환

package codingtest_practice.level2;

import java.util.*;

public class TransNumber {

    Set<Integer> set = new HashSet<>();
    Set<Integer> temp;
    int target;

    public int solution1(int x, int y, int n) {
        int answer = 0;
        target = y;
        set.add(x);

        while (!set.isEmpty()) {
            if (set.contains(y)) {
                return answer;
            }
            temp = new HashSet<>();
            for (int num : set) {
                save(num + n);
                save(num * 2);
                save(num * 3);
            }
            answer++;
            set = temp;
        }

        return -1;
    }

    private void save(int n) {
        if (n <= target && !set.contains(n)) {
            temp.add(n);
        }
    }

    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];

        Arrays.fill(dp, -1);
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == -1) continue;
            save(i, y, i + n, dp);
            save(i, y, i * 2, dp);
            save(i, y, i * 3, dp);
        }
        return dp[y];
    }

    private void save(int origin, int target, int num, int[] dp) {
        if (num <= target) {
            if (dp[num] == -1) {
                dp[num] = dp[origin] + 1;
            } else {
                dp[num] = Math.min(dp[origin] + 1, dp[num]);
            }
        }
    }
}
