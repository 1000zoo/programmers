//https://school.programmers.co.kr/learn/courses/30/lessons/70129
//2022-09-26
//이진 변환 반복하기

package codingtest_practice.level2;

public class StringBinaryTranslate {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        String temp;
        while (!s.equals("1")) {
            temp = s;
            s = s.replace("0", "");
            answer[1] += temp.length() - s.length();
            answer[0]++;
            s = toBinary(s.length());
        }

        return answer;
    }

    private static String toBinary(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            result.append(n % 2);
            n /= 2;
        }
        return result.reverse().toString();
    }
}
