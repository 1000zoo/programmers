//2023-06-27
//https://school.programmers.co.kr/learn/courses/30/lessons/131128
//숫자 짝궁

package codingtest_practice.level1;

import java.util.*;

public class PartnerNumber {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        boolean onlyZero = true;

        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }

        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            int length = Math.min(xCount[i], yCount[i]);
            if (length > 0 && i != 0) onlyZero = false;
            String temp = "" + i;
            answer.append(temp.repeat(length));
        }

        return answer.length() == 0 ? "-1" : onlyZero ? "0" : answer.toString();
    }
}
