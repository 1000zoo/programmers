//2023-04-12
//https://school.programmers.co.kr/learn/courses/30/lessons/178870
//연속된 부분 수열의 합

package codingtest_practice.level2;

public class SumOfSubsequence {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        int length = sequence.length;

        while (end != length || sum >= k) {
            if (sum == k) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    answer = new int[]{start, end - 1};
                }
            }

            if (end < length && sum < k) {
                sum += sequence[end++];
            } else if (start < length) {
                sum -= sequence[start++];
            }
        }
        return answer;
    }
}
