//2023-09-24
//https://school.programmers.co.kr/learn/courses/30/lessons/64061?language=java#
//크레인 인형뽑기 게임

package codingtest_practice.level1;

import java.util.*;

public class ClawMachineGame {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int doll = pickDoll(board, move - 1);
            if (doll == 0) continue;
            if (stack.empty() || stack.peek() != doll) {
                stack.push(doll);
            } else {
                stack.pop();
                answer += 2;
            }
        }


        return answer;
    }

    private int pickDoll(int[][] board, int move) {
        for (int i = 0; i < board.length; i++) {
            int temp = board[i][move];
            if (temp != 0) {
                board[i][move] = 0;
                return temp;
            }
        }
        return 0;
    }
}
