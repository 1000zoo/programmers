//https://school.programmers.co.kr/learn/courses/30/lessons/161989
//2023-05-01
//덧칠하기

package codingtest_practice.level1;

import java.util.*;

public class Repaint {
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
