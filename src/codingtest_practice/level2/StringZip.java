//2023-09-06
//https://school.programmers.co.kr/learn/courses/30/lessons/60057
//문자열 압축

package codingtest_practice.level2;

public class StringZip {

    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, getLength(s, i));
        }

        return answer;
    }

    private int getLength(String s, int cut) {
        String prev = s.substring(0, cut);
        int dupCount = 1;
        int length = 0;
        int i = 1;

        for (; i < (s.length() / cut); i++) {
            String curr = s.substring(i * cut, (i + 1) * cut);
            if (prev.equals(curr)) {
                dupCount++;
            } else {
                if (dupCount > 1)
                    length += (prev + dupCount).length();
                else length += prev.length();
                dupCount = 1;
                prev = curr;
            }
        }
        if (dupCount > 1)
            length += (prev + dupCount).length();
        else length += prev.length();
        length += s.length() - (i * cut);

        return length;
    }
}
