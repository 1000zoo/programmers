//https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=java
//2022-12-01
//파일명 정렬

package codingtest_practice.level2;

import java.util.*;

public class FileSorting {

    //Time : Arrays.sort => O(NlogN)
    //Space: O(s) (s : files 의 원소 길이)
    public String[] solution(String[] files) {
        Arrays.sort(files, this::compare);
        return files;
    }

    private int compare(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        String h1 = headPart(s1), h2 = headPart(s2);
        int n1 = numPart(s1, h1.length()), n2 = numPart(s2, h2.length());

        // head 부분이 다르다면 head 끼리 비교
        if (!h1.equals(h2)) return h1.compareTo(h2);
        // 그 외의 경우 숫자 부분만 비교 (같으면 0 => 기존 순서 유지)
        return Integer.compare(n1, n2);
    }

    // 숫자 이전의 부분
    private String headPart(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isNum(c)) break;
            sb.append(c);
        }
        return sb.toString();
    }

    // 숫자 부분
    private int numPart(String s, int headSize) {
        StringBuilder sb = new StringBuilder();

        for (int i = headSize; i < s.length(); i++) {
            if (!isNum(s.charAt(i))) break;
            sb.append(s.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}

