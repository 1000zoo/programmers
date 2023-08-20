//2023-08-20
//https://school.programmers.co.kr/learn/courses/30/lessons/67258
//보석 쇼

package codingtest_practice.level3;

import java.util.*;

public class JewelryShopping {

    private Map<String, Integer> gemCounts;

    public int[] solution(String[] gems) {
        int[] answer = {0, gems.length};
        String[] g = new String[gems.length + 1];
        Set<String> types = new HashSet<>();
        gemCounts = new HashMap<>();

        for (int i = 0; i < gems.length; i++) {
            types.add(gems[i]);
            g[i + 1] = gems[i];
        }

        int total = types.size();
        System.out.println(total);
        int s = 1;
        int e = 0;
        boolean sTurn = false;

        while ((s != e) || (s != g.length)) {
            if (sTurn) rmGem(g[s++]);
            else addGem(g[++e]);

            if (gemCounts.size() < total) {
                sTurn = false;
                if (e == g.length - 1) return answer;
            } else if (gemCounts.size() == total) {
                sTurn = true;
                if (answer[1] - answer[0] > e - s) {
                    answer = new int[]{s, e};
                }
            }
        }

        return answer;
    }

    private void rmGem(String gem) {
        gemCounts.put(gem, gemCounts.get(gem) - 1);
        if (gemCounts.get(gem) == 0) gemCounts.remove(gem);
    }

    private void addGem(String gem) {
        gemCounts.put(gem, gemCounts.getOrDefault(gem, 0) + 1);
    }
}
