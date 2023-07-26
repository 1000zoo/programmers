//https://school.programmers.co.kr/learn/courses/30/lessons/12926
//2022-10-10 && 2023-07-26
//시저 암호

package codingtest_practice.level1;

import java.util.*;

public class CaesarCipher {
    public String solution(String s, int n) {
        return String.join("", Arrays.stream(s.split(""))
                .map(c -> c.equals(" ") ? " " : c.toLowerCase().equals(c) ?
                        "" + (char) (((c.charAt(0) - 'a' + n) % 26 + 'a')) :
                        "" + (char) (((c.charAt(0) - 'A' + n) % 26 + 'A')))
                .toArray(String[]::new));
    }

    //효율성 승
    public String prevSolution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        char temp = '-';
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
            } else {
                temp = (char) ((int) c + n);
                if (c >= 'A' && c <= 'Z') {
                    if (temp > 'Z') {
                        temp -= ('Z' - 'A' + 1);
                    }
                } else if (c >= 'a' && c <= 'z') {
                    if (temp > 'z') temp -= ('z' - 'a' + 1);
                }
                answer.append(temp);
            }
        }
        return answer.toString();
    }
}
