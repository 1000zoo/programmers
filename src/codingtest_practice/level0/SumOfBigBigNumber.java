//2023-07-10
//https://school.programmers.co.kr/learn/courses/30/lessons/181846?language=java
//두 수의 합

package codingtest_practice.level0;

public class SumOfBigBigNumber {
    public String solution(String a, String b) {
        StringBuilder answer = new StringBuilder();
        String longer = a.length() > b.length() ? a : b;
        String shorter = a.length() > b.length() ? b : a;

        longer = new StringBuilder(longer).reverse().toString();
        shorter = new StringBuilder(shorter).reverse().toString();

        int sum = 0;
        int carry = 0;
        int l = 0;
        int s = 0;

        for (int i = 0; i < longer.length(); i++) {
            l = Integer.parseInt("" + longer.charAt(i));
            s = shorter.length() > i ? Integer.parseInt("" + shorter.charAt(i)) : 0;

            sum = (carry + l + s) % 10;
            carry = (carry + l + s) / 10;

            answer.append(sum);
        }
        if (carry == 1) answer.append(carry);
        return answer.reverse().toString();
    }
}
