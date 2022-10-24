//https://school.programmers.co.kr/learn/courses/30/lessons/42577#
//2022-10-24
//전화번호 목록

package codingtest_practice.level2;

import java.util.*;

public class PhoneBookList {
    public boolean solution(String[] phone_book) {
        Set<String> num_set = new HashSet<>();

        for (String num : phone_book) {
            num_set.add(num.trim());
        }

        for (String num : phone_book) {
            String temp = "";
            for (int i = 0; i < num.length() - 1; i++) {
                temp += num.charAt(i);
                if (num_set.contains(temp)) {
                    return false;
                }
            }
        }
        return true;
    }
}
