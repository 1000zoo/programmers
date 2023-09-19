//2023-09-19
//https://school.programmers.co.kr/learn/courses/30/lessons/87377
//교점에 별 만들기

package codingtest_practice.level2;

import java.util.*;

public class DotCrossLine {
    public String[] solution(int[][] line) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] eq = equations(line[i], line[j]);
                if (eq == null) continue;
                set.add(eq[0] + "," + eq[1]);
            }
        }

        int[][] dots = new int[set.size()][];
        int index = 0;

        for (String s : set) {
            String[] temp = s.split(",");
            dots[index++] = new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
        }

        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] dot : dots) {
            maxX = Math.max(maxX, dot[0]);
            maxY = Math.max(maxY, dot[1]);
            minX = Math.min(minX, dot[0]);
            minY = Math.min(minY, dot[1]);
        }

        int maxWidth = maxX - minX + 1;
        int maxHeight = maxY - minY + 1;

        String[] answer = new String[maxHeight];
        Arrays.fill(answer, ".".repeat(maxWidth));

        for (int[] dot : dots) {
            int x = dot[0] - minX;
            int y = maxY - dot[1];
            String temp = answer[y];
            answer[y] = temp.substring(0, x) + "*" + temp.substring(x + 1);
        }

        return answer;
    }

    private int[] equations(int[] a, int[] b) {
        if (a[0]*b[1] - a[1]*b[0] == 0) {
            return null;
        }
        long X = (long) a[1]*b[2] - (long) a[2]*b[1];
        long Y = (long) a[2]*b[0] - (long) a[0]*b[2];
        long R = (long) a[0]*b[1] - (long) a[1]*b[0];

        if (X % R != 0 || Y % R != 0) return null;

        long x = (X / R);
        long y = (Y / R);

        return new int[] {(int) x, (int) y};
    }
}
