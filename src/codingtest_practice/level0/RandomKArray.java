//2023-06-20
//https://school.programmers.co.kr/learn/courses/30/lessons/181858
//무작위로 k개의 수 뽑기

package codingtest_practice.level0;

import java.util.*;

public class RandomKArray {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        Set<Integer> set = new HashSet<>();
        int index = 0;

        for (int n : arr) {
            if (!set.contains(n)) {
                answer[index++] = n;
                set.add(n);
            }
            if (index == k) break;
        }

        return answer;
    }
}
