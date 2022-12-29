//
//2022-12-29
//크기가 작은 부분 문자열

package codingtest_practice.level1;

public class LessSubstring {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String temp = t.substring(i, i + p.length());
            if (Long.parseLong(temp) <= Long.parseLong(p)) answer++;
        }

        return answer;
    }
}
