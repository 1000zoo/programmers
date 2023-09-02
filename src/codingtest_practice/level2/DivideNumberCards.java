//2023-09-02
//https://school.programmers.co.kr/learn/courses/30/lessons/135807
//숫자 카드 나누기

package codingtest_practice.level2;

import java.util.*;

public class DivideNumberCards {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        return Math.max(getAnswer(arrayA, arrayB), getAnswer(arrayB, arrayA));
    }

    private int getAnswer(int[] arr1, int[] arr2) {
        boolean finish = true;
        List<Integer> elements = getElements(arr1[0]);

        for (int e : elements) {
            finish = true;
            for (int i = 0; i < arr1.length; i++) {
                int a = arr1[i];
                int b = arr2[i];

                if (!(a % e == 0 && b % e != 0)) {
                    finish = false;
                    break;
                }
            }
            if (finish) return e;
        }
        return 0;
    }

    private List<Integer> getElements(int num) {
        List<Integer> results = new ArrayList<>();

        for (int i = num; i > 1; i--) {
            if (num % i == 0) results.add(i);
        }

        return results;
    }
}
