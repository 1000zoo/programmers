//2023-10-01
//https://school.programmers.co.kr/learn/courses/30/lessons/12904
//가장 긴 펠린드롬

package codingtest_practice.level3;

public class LongestPalindrome {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, helper(s, i, i));
            answer = Math.max(answer, helper(s, i, i + 1));
        }

        return answer;
    }

    private int helper(String s, int start, int end) {
        while (0 <= start && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) break;
            start--;
            end++;
        }
        return end - start - 1;
    }
}
