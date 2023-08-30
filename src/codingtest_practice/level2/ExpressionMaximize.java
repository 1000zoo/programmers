//2023-08-31
//https://school.programmers.co.kr/learn/courses/30/lessons/67257?language=java
//수식 최대화

package codingtest_practice.level2;

import java.util.*;

public class ExpressionMaximize {
    public long solution(String expression) {
        long answer = 0;
        String[] order = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};

        for (String o : order) {
            long temp = calculation(new String(expression), o);
            answer = Math.max(Math.abs(temp), answer);
        }

        return answer;
    }

    private long calculation(String expression, String operations) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        String num = "";
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num += c;
            } else {
                numbers.add(Long.parseLong(num));
                operators.add(c);
                num = "";
            }
        }
        numbers.add(Long.parseLong(num));

        for (char op : operations.toCharArray()) {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i) == op) {
                    long a = numbers.get(i);
                    long b = numbers.get(i + 1);

                    long result = calculate(a, b, op);

                    numbers.set(i, result);
                    numbers.remove(i + 1);
                    operators.remove(i);

                    i--;
                }
            }
        }

        return numbers.get(0);
    }

    private long calculate(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}
