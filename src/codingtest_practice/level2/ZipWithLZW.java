//https://school.programmers.co.kr/learn/courses/30/lessons/17684
//2022-10-30
//압축

package codingtest_practice.level2;

import java.util.*;

public class ZipWithLZW {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            dict.put("" + c, (int) c - 'A' + 1);
        }
        String temp = "";
        String backup = "";
        for (char c : msg.toCharArray()) {
            temp += c;
            if (!dict.containsKey(temp)) {
                dict.put(temp, dict.size() + 1);
                answer.add(dict.get(backup));
                temp = "" + c;
                backup = "" + c;
            } else {
                backup = temp;
            }
        }
        answer.add(dict.get(backup));
        System.out.println(dict);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
