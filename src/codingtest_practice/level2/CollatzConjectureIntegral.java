//2023-09-10
//https://school.programmers.co.kr/learn/courses/30/lessons/134239#
//우박수열 정적분

package codingtest_practice.level2;

import java.util.*;

public class CollatzConjectureIntegral {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double[] areas = eachArea(getCollatz(k));

        for (int i = 0; i < answer.length; i++) {
            answer[i] = rangeArea(areas, ranges[i]);
        }

        return answer;
    }

    private double rangeArea(double[] areas, int[] range) {
        double area = 0;
        int s = range[0];
        int e = areas.length + range[1];

        if (s > e) return -1;

        for (int i = s; i < e; i++) {
            area += areas[i];
        }

        return area;
    }

    private double[] eachArea(int[] collatz) {
        double[] areas = new double[collatz.length - 1];

        for (int i = 0; i < collatz.length - 1; i++) {
            areas[i] = ((double) collatz[i] + collatz[i + 1]) / 2;
            System.out.print(areas[i] + ",");
        }

        return areas;
    }

    private int[] getCollatz(int k) {
        List<Integer> list = new ArrayList<>();

        while (k > 1) {
            list.add(k);
            k = k % 2 == 0 ? k / 2 : (k * 3) + 1;
        }
        list.add(1);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
