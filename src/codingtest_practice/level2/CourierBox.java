//2023-07-19
//https://school.programmers.co.kr/learn/courses/30/lessons/131704
//택배 상자

package codingtest_practice.level2;

import java.util.*;

public class CourierBox {
    public int solution(int[] order) {
        int answer = 0;
        int box = 1;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        
        while (true) {
            if (box < order[index]) {
                for (; box < order[index]; box++) stack.push(box);
            } else if (box == order[index]) {
                answer++;
                index++;
                box++;
            } else if (!stack.isEmpty() && stack.peek() == order[index]) {
                answer++;
                index++;
                stack.pop();
            } else {
                break;
            }
            if (index == order.length) break;
        }
        
        return answer;
    }
}
