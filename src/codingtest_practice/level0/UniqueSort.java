//2023-06-12
//https://school.programmers.co.kr/learn/courses/30/lessons/120880
//특이한 정렬

package codingtest_practice.level0;

import java.util.*;

public class UniqueSort {
    public int[] solution(int[] numlist, int n) {
        List<Integer> list = new ArrayList<>();
        for (int j : numlist) {
            list.add(j);
        }

        list.sort((i1, i2) -> compare(i1, i2, n));

        return list.stream().mapToInt(i->i).toArray();
    }

    private int compare(int i1, int i2, int n) {
        int temp1 = Math.abs(i1 - n);
        int temp2 = Math.abs(i2 - n);

        if (temp1 == temp2) {
            return Integer.compare(i2, i1);
        }
        return Integer.compare(temp1, temp2);
    }
}
