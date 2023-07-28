//2023-07-28
//https://school.programmers.co.kr/learn/courses/30/lessons/60058
//괄호 변환

package codingtest_practice.level2;

import java.util.*;

class ConvertParenthesis {
    public String solution(String p) {
        return dfs(p);
    }

    private String dfs(String s) {
        if (s.length() == 0) return s;
        int l = 0;
        int r = 0;
        int index = 0;
        do {
            if (isLeft(s.charAt(index++))) l++;
            else r++;
        } while (l != r);
        String u = s.substring(0, index);
        String v = s.substring(index);

        String answer;
        if (isBalanced(u)) {
            answer = u + dfs(v);
        } else {
            answer = "(" + dfs(v) + ")" + revert(u.substring(1, index - 1));
        }

        return answer;
    }

    private String revert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isLeft(c)) sb.append(")");
            else sb.append("(");
        }
        return sb.toString();
    }

    private boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isLeft(c)) st.push(c);
            else {
                if (st.isEmpty()) return false;
                st.pop();
            }

        }
        return st.isEmpty();
    }

    private boolean isLeft(char c) {
        return c == '(';
    }
}

/*
1. (와 )의 수가 같으면 반복문 잠시 stop
1-1. 현재까지를 u, 이후를 v

2. u가 올바른 문자열인지 확인 (Stack 이용)
2-1. 맞다면 answer += u, v에 대해 1번 부터 시행
2-2. 아니라면, v에 대해 1번부터 수행하고, 해당 결과 func(v)를 ( + func(v) + )
    2-2-1. u의 첫, 마지막 문자 제거, 나머지 방향을 뒤집어 2-2의 결과에 추가
    2-2-2. 해당 결과를 리턴
*/