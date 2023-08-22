//https://school.programmers.co.kr/learn/courses/30/lessons/161989
//2023-05-01
//덧칠하기

package codingtest_practice.level1;

import java.util.*;

public class Repaint {

    public int newSolution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];

        for (int sec : section) {
            if (m > sec - start) continue;
            start = sec;
            answer++;
        }

        return answer;
    }

    public int solution(int n, int m, int[] section) {
        int answer = 0;

        for (int i = 0; i < section.length;) {
            int temp = section[i] + m;
            while (i < section.length) {
                if (section[i] < temp) {
                    i++;
                } else {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}
