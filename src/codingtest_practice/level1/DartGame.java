//https://school.programmers.co.kr/learn/courses/30/lessons/17682
//2022-10-26
//다트 게임

package codingtest_practice.level1;

import java.util.*;

public class DartGame {
    public int solution(String dartResult) {
        int currPoint = 0;
        int currIndex = 0;

        int[] points = new int[3];


        for (char c : dartResult.toCharArray()) {
            if (isNum(c)) {
                currPoint *= 10;
                currPoint += (c - '0');
            } else {
                if (isAlp(c)) {
                    currPoint = (int) Math.pow(currPoint, decode(c));
                    points[currIndex++] = currPoint;
                    currPoint = 0;
                } else {
                    if (c == '*') {
                        if (currIndex != 1) {
                            points[currIndex - 2] *= 2;
                        }
                        points[currIndex - 1] *= 2;
                    } else if (c == '#') {
                        points[currIndex - 1] *= -1;
                    }
                }
            }
        }

        return Arrays.stream(points).sum();
    }

    private int decode(char c) {
        if (c == 'S') {
            return 1;
        } else if (c == 'D') {
            return 2;
        } else if (c == 'T') {
            return 3;
        } else {
            return -1;
        }
    }

    private boolean isAlp(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
