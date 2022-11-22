//https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=java
//2022-11-23
//파일명 정렬

package codingtest_practice.level2;

import java.util.*;

public class FileSorting {

    //테스트케이스 6,7,8,9 안됨
    public String[] solution(String[] files) {

        Arrays.sort(files, this::comparator);

        for (String file : files) {
            System.out.println("file = " + file);
        }

        return files;
    }

    private int comparator(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int i1 = IntStartIndex(s1), i2 = IntStartIndex(s2);
        int tc1 = trollCharIndex(s1), tc2 = trollCharIndex(s2);

        if (tc1 != tc2 && (tc1 < i1 && tc2 < i2)) {
            return s1.compareTo(s2);
        }

        if (i1 != i2) {
            return s1.compareTo(s2);
        } else if (i1 == -1) {
            return s1.compareTo(s2);
        } else if (!s1.substring(0, i1).equals(s2.substring(0, i2))) {
            return s1.compareTo(s2);
        } else {
            int e1 = IntEndIndex(s1, i1), e2 = IntEndIndex(s2, i2);
            s1 = s1.substring(i1, e1);
            s2 = s2.substring(i2, e2);
            return Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2));
        }
    }

    private int IntStartIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (isNum(s.charAt(i))) return i;
        }
        return -1;
    }
    private int IntEndIndex(String s, int start) {
        for (int i = start; i < s.length(); i++) {
            if (!isNum(s.charAt(i))) return i;
        }
        return s.length();
    }

    private int trollCharIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (trollChar(s.charAt(i))) return i;
        }
        return -1;
    }

    private boolean trollChar(char c) {
        return c == ' ' || c == '-' || c == '.';
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}

