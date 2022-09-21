//
//2022-09-21
//문자열 내림차순으로 배치하기

package codingtest_practice.level1;

public class StringSort {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int[] count = new int[128];
        String temp = "";
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (int i = 0; i < count.length; i++) {
            temp = "";
            if (count[i] != 0) {
                temp += (char) i;
                answer.append(temp.repeat(count[i]));
            }
        }
        answer.reverse();
        return answer.toString();
    }
}
