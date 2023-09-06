//2023-09-06
//https://school.programmers.co.kr/learn/courses/30/lessons/147354
//테이블 해시 함수

package codingtest_practice.level2;

import java.util.*;

public class TableHashFunction {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> o1[col - 1] == o2[col - 1] ?
                Integer.compare(o2[0], o1[0]) :
                Integer.compare(o1[col - 1], o2[col - 1]));

        int[] si = new int[row_end - row_begin + 1];

        for (int i = row_begin; i <= row_end; i++) {
            int temp = 0;
            for (int r : data[i - 1]) {
                temp += (r % i);
            }
            si[i - row_begin] = temp;
        }

        return Arrays.stream(si).reduce((a, b) -> a ^ b).orElse(0);
    }
}
