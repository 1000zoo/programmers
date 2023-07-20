//2023-07-21
//https://school.programmers.co.kr/learn/courses/30/lessons/12899?language=java
//124 나라

package codingtest_practice.level2;

public class World124 {

    //used memoization (time limitation)
    public String memoization(int n) {
        if (n == 1) return "1";
        if (n == 2) return "2";
        if (n == 3) return "4";

        String[] d = {"4", "1", "2"};
        String[] memo = new String[n + 1];
        memo[1] = "1";
        memo[2] = "2";
        memo[3] = "4";

        for (int i = 4; i <= n; i++) {
            memo[i] = memo[(i - 1) / 3] + d[i % 3];
        }

        return memo[n];
    }

    //시간제한 통과
    public String solution(int n) {

        String[] numbers = {"4", "1", "2"};
        StringBuilder answer = new StringBuilder();

        while(n > 0) {
            int remainder = n % 3;
            n /= 3;

            if(remainder == 0) n--;

            answer.insert(0, numbers[remainder]);
        }

        return answer.toString();
    }
}
