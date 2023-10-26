//2023-10-26
//https://school.programmers.co.kr/learn/courses/30/lessons/77886
//110 옮기기

package codingtest_practice.level3;

public class Move110 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            answer[i] = process(s[i]);
        }
        return answer;
    }

    private String process(String s) {
        int count110 = 0;
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            stack.append(c);
            if (stack.length() >= 3 && "110".equals(stack.substring(stack.length() - 3))) {
                count110++;
                stack.delete(stack.length() - 3, stack.length());
            }
        }

        if (!stack.toString().contains("0")) {
            return "110".repeat(count110) + stack.toString();
        }

        int insertIndex = 0;
        for (int i = stack.length() - 1; i >= 0; i--) {
            if (stack.charAt(i) == '0') {
                insertIndex = i + 1;
                break;
            }
        }

        return stack.substring(0, insertIndex) + "110".repeat(count110) + stack.substring(insertIndex);
    }
}
