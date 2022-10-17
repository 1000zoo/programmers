//https://school.programmers.co.kr/learn/courses/30/lessons/12915
//2022-10-17
//문자열 내 마음대로 정렬하기

package codingtest_practice.level1;

public class StringSortByNthIndex {
    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length - 1; i++) {

            for (int j = i + 1; j < strings.length; j++) {
                char ni = strings[i].charAt(n);
                char nj = strings[j].charAt(n);
                if (Character.compare(ni, nj) > 0) {
                    swap(strings, i, j);
                } else if (Character.compare(ni, nj) == 0) {
                    if (strings[i].compareTo(strings[j]) > 0) {
                        swap(strings, i, j);
                    }
                }
            }
        }
        return strings;
    }
    private void swap(String[] s, int i1, int i2) {
        String temp = s[i1];
        s[i1] = s[i2];
        s[i2] = temp;
    }
}
