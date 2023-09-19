//2023-09-20
//https://school.programmers.co.kr/learn/courses/30/lessons/1835
//단체사진 찍기

package codingtest_practice.level2;

import java.util.*;

public class GroupPhoto {

    public int solution(int n, String[] data) {
        return permutation(new ArrayList<>(), 0, data);
    }

    private boolean metCondition(String s, String data) {
        int between = Integer.parseInt("" + data.charAt(4));

        int f1 = s.indexOf(data.charAt(0));
        int f2 = s.indexOf(data.charAt(2));

        if (data.charAt(3) == '<') {
            return Math.abs(f1 - f2) - 1 < between;
        } else if (data.charAt(3) == '>') {
            return Math.abs(f1 - f2) - 1 > between;
        } else {
            return Math.abs(f1 - f2) - 1 == between;
        }
    }

    private int permutation(List<String> curr, int answer, String[] data) {
        if (curr.size() == 8) {
            String s = "";
            for (String c : curr) s += c;

            for (String d : data) {
                if (!metCondition(s, d)) return answer;
            }

            return answer + 1;
        }

        String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

        for (String f : friends) {
            if (curr.contains(f)) continue;
            curr.add(f);
            answer = permutation(curr, answer, data);
            curr.remove(f);
        }

        return answer;
    }
}
