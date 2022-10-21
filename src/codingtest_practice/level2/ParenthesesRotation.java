//https://school.programmers.co.kr/learn/courses/30/lessons/76502
//2022-10-21
//괄호 회전시키기

package codingtest_practice.level2;

import java.util.Stack;

public class ParenthesesRotation {
    public static int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s)) {
                answer++;
            }
            s = rotation(s);
        }
        return answer;
    }

    private static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (st.isEmpty()) {
                st.push(c);
            } else {
                if (getPair(st.peek()) == c) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }

        }
        return st.isEmpty();
    }

    private static String rotation(String s) {
        return s.substring(1) + s.charAt(0);
    }

    private static char getPair(char c) {
        if (c == '[') {
            return ']';
        } else if (c == '{') {
            return '}';
        } else if (c == '(') {
            return ')';
        } else {
            return '-';
        }
    }

    public static void main(String[] args) {
        solution("[)(]");
    }
}
