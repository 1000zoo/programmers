//2023-07-12
//https://school.programmers.co.kr/learn/courses/30/lessons/42839
//소수 찾기

package codingtest_practice.level2;

import java.util.*;

public class FindPrimeNumComb {

    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        setting("", numbers);
        return (int) set.stream().filter(this::isPrimary).count();
    }

    private void setting(String curr, String other) {
        if (curr.length() != 0) set.add(Integer.parseInt(curr));
        for (int i = 0; i < other.length(); i++) {
            setting(curr + other.charAt(i), other.substring(0, i) + other.substring(i + 1));
        }
    }

    private boolean isPrimary(int num) {
        if (num < 2) return false;
        for (int i = 2; i < (int) Math.sqrt(num) + 1; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
