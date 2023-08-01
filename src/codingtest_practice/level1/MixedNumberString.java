//2023-10-17 (resolve: 2023-08-02)
//https://school.programmers.co.kr/learn/courses/30/lessons/81301
//숫자 문자열과 영단어

package codingtest_practice.level1;

public class MixedNumberString {
    public int solution(String s) {
        String[] list = {"zero", "one", "two", "three", "four",	"five",	"six", "seven", "eight", "nine"};

        for (int i = 0; i < list.length; i++) {
            s = replace(s, list[i], "" + i);
        }
        return Integer.parseInt(s);
    }

    private String replace(String ori, String from, String to) {
        return ori.replace(from, to);
    }

    public int solution2(String s) {
        int answer = 0;
        String temp = "";

        for (char c : s.toCharArray()) {
            temp += c;
            if (encoder(temp) >= 0) {
                answer *= 10;
                answer += encoder(temp);
                temp = "";
            }
        }
        return answer;
    }

    private int encoder(String s) {
        if (s.equals("zero") || s.equals("0")) return 0;
        else if (s.equals("one") || s.equals("1")) return 1;
        else if (s.equals("two") || s.equals("2")) return 2;
        else if (s.equals("three") || s.equals("3")) return 3;
        else if (s.equals("four") || s.equals("4")) return 4;
        else if (s.equals("five") || s.equals("5")) return 5;
        else if (s.equals("six") || s.equals("6")) return 6;
        else if (s.equals("seven") || s.equals("7")) return 7;
        else if (s.equals("eight") || s.equals("8")) return 8;
        else if (s.equals("nine") || s.equals("9")) return 9;
        else return -1;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
