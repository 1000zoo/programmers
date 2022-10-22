//https://school.programmers.co.kr/learn/courses/30/lessons/17677
//2022-10-22
//뉴스 클러스터링

package codingtest_practice.level2;

import java.util.*;
import java.util.regex.*;

public class NewsClustering {
    public int solution(String str1, String str2) {

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Map<String, Integer> dup1 = new HashMap<>();
        Map<String, Integer> dup2 = new HashMap<>();

        for (String s : getSet(str1.toLowerCase())) {
            if (!set1.add(s)) {
                dup1.put(s, dup1.getOrDefault(s, 0) + 1);
            }
        }
        for (String s : getSet(str2.toLowerCase())) {
            if (!set2.add(s)) {
                dup2.put(s, dup2.getOrDefault(s, 0) + 1);
            }
        }
        if (set1.isEmpty() && set2.isEmpty()) return 65536;
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        Set<String> inter = new HashSet<>(set1);
        inter.retainAll(set2);
        int forU = 0;
        int forI = 0;
        for (String s : union) {
            forU += Math.max(dup1.getOrDefault(s, 0), dup2.getOrDefault(s, 0));
        }
        for (String s : inter) {
            forI += Math.min(dup1.getOrDefault(s, 0), dup2.getOrDefault(s, 0));
        }

        return (int) ((65536 * ((double)(inter.size() + forI) / (union.size() + forU))));
    }

    private String[] getSet(String str) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            if (onlyEng("" + str.charAt(i) + str.charAt(i + 1))){
                results.add("" + str.charAt(i) + str.charAt(i + 1));
            }
        }
        return results.toArray(String[]::new);
    }
    private boolean onlyEng(String str) {
        return Pattern.matches("^[a-zA-Z]*$", str);
    }
}
