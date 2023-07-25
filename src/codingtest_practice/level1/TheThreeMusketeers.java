//2023-07-26
//https://school.programmers.co.kr/learn/courses/30/lessons/131705?language=java
//삼총사

package codingtest_practice.level1;

import java.util.*;

public class TheThreeMusketeers {
    Stack<Integer> stk;
    int[] number;
    public int newSolution(int[] number) {
        this.number = number;
        stk = new Stack<>();
        return dfs(0, 0);
    }
    private int dfs(int index, int answer) {
        if (stk.size() == 3) {
            return isSumZero() ? answer+1 : answer;
        }
        for (int i = index; i < number.length; i++) {
            stk.push(number[i]);
            answer = dfs(i+1, answer);
            stk.pop();
        }
        return answer;
    }
    private boolean isSumZero() {
        return stk.stream().mapToInt(i->i).sum() == 0;
    }
    public int prevSolution(int[] number) {
        int answer = 0;
        int temp = 0;
        for (int i = 0; i < number.length - 2; i++) {
            temp += number[i];
            for (int j = i + 1; j < number.length - 1; j++) {
                temp += number[j];
                for (int k = j + 1; k < number.length; k++) {
                    temp += number[k];
                    if (temp == 0) {
                        answer++;
                    }
                    temp -= number[k];
                }
                temp -= number[j];
            }
            temp -= number[i];
        }
        return answer;
    }
}
