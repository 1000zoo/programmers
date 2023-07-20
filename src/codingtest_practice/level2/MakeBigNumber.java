//2023-07-20
//https://school.programmers.co.kr/learn/courses/30/lessons/42883
//큰 수 만들기

package codingtest_practice.level2;

import java.util.*;

class MakeBigNumber {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = Arrays.stream(number.split("")).mapToInt(i -> Integer.parseInt(i)).toArray();
        
        for (int n : arr) {
            while (!stack.isEmpty() && stack.peek() < n && k-- > 0) {
                stack.pop();
            }
            stack.push(n);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int a : stack) {
            sb.append(a);
        }
        return sb.toString();
    }
}
