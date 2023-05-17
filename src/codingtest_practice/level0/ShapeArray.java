//2023-05-18
//https://school.programmers.co.kr/learn/courses/30/lessons/181893
//배열 조각하기

package codingtest_practice.level0;

import java.util.*;

public class ShapeArray {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 1) {
                answer = Arrays.copyOfRange(answer, query[i], answer.length);
            } else {
                answer = Arrays.copyOfRange(answer, 0, query[i] + 1);
            }
        }
        return answer;
    }
}
