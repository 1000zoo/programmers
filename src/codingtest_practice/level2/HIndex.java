package codingtest_practice.level2;

import java.util.*;

public class HIndex {
    public int solution(int[] citations) {
        int max = 0;
        Arrays.sort(citations);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < citations.length; i++) {
            if (!set.contains(citations[i])) {
                set.add(citations[i]);
                if (citations.length - i <= citations[i]) {
                    max = Math.max(citations.length - i, max);
                }
            }
        }
        return max;
    }
}
