//https://school.programmers.co.kr/learn/courses/30/lessons/135808
//2023-01-05
//과일 장수

package codingtest_practice.level1;

import java.util.*;

public class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int stop = score.length - (score.length / m) * m;
        for (int i = score.length - m; i >= stop; i -= m) {
            answer += score[i] * m;
        }
        return answer;
    }
}
