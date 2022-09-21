//https://school.programmers.co.kr/learn/courses/30/lessons/12951
//2022-09-21
//제이든 케이스 (단어의 첫 문자을 대문자로, 나머지는 소문자로)

package codingtest_practice.level1;

class JadenCase {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean start = true;
        char temp = ' ';

        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (start) {
                if (temp == ' ') {
                    answer.append(temp);
                    continue;
                }
                if (isAlphabet(temp) && Character.isLowerCase(temp)) {
                    temp += ('A' - 'a');
                }
                start = false;
            } else {
                if (Character.isUpperCase(temp)) {
                    temp -= ('A' - 'a');
                } else if (temp == ' ') {
                    start = true;
                }
            }
            answer.append(temp);
        }
        return answer.toString();
    }

    private boolean isAlphabet(char c) {
        return Character.isLowerCase(c) || Character.isUpperCase(c);
    }
}
