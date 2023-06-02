//2023-06-03
//https://school.programmers.co.kr/learn/courses/30/lessons/181921#
//배열 만들기

package codingtest_practice.level0;

import java.util.*;

public class ArrayGenerator02 {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; getBinaryInt(i) * 5 <= r; i++) {
            if (boundary(i, l, r)) answer.add(getBinaryInt(i) * 5);
        }
        if (answer.isEmpty()) return new int[]{-1};
        return answer.stream().mapToInt(i->i).toArray();
    }
    private boolean boundary(int num, int l, int r) {
        return l <= 5 * getBinaryInt(num) && 5 * getBinaryInt(num) <= r;
    }
    private int getBinaryInt(int num) {
        return Integer.parseInt(Integer.toBinaryString(num));
    }
}
