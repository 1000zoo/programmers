//https://school.programmers.co.kr/learn/courses/30/lessons/12906
//2022-09-27
//같은 숫자는 시렁

package codingtest_practice.level1;

import java.util.Stack;

public class NoIdenticalNumber {
    public int[] solution(int []arr) {
        if (arr.length == 0) return arr;
        Stack<Integer> st = new Stack<>(){{
            push(arr[0]);
        }};
        for (int i = 1; i < arr.length; i++) {
            if (st.peek() != arr[i]) {
                st.push(arr[i]);
            }
        }

        int[] answer = new int[st.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }

        return answer;
    }
}
