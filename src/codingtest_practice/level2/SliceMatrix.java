//https://school.programmers.co.kr/learn/courses/30/lessons/87390
//2022-10-22
//n * n 배열 자르기

package codingtest_practice.level2;

import java.util.*;

public class SliceMatrix {
    public static int[] solution(int n, long left, long right) {
        List<Integer> list = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            list.add((int)Math.max(1 + (i / n), 1 + (i % n)));
        }
        int index = (int) (right - left + 1);
        int[] answer = new int[index];
        for (int i = 0; i < index; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
