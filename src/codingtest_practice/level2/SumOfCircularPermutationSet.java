//https://school.programmers.co.kr/learn/courses/30/lessons/131701
//2022-12-11
//연속 부분 수열 합의 개수

package codingtest_practice.level2;

import java.util.*;

public class SumOfCircularPermutationSet {
    public int solution(int[] elements) {
        Set<Integer> sumSet = new HashSet<>();

        for (int len = 1; len <= elements.length; len++) {
            for (int i = 0; i < elements.length; i++) {
                int sum = 0;
                for (int j = i; j < i + len; j++) {
                    int index = j;
                    if (j >= elements.length) {
                        index = j - elements.length;
                    }
                    sum += elements[index];
                }
                sumSet.add(sum);
            }
        }
        return sumSet.size();
    }
}
