//2023-09-08
//https://school.programmers.co.kr/learn/courses/30/lessons/42890#
//후보키

package codingtest_practice.level2;

import java.util.*;

public class CandidateKey {




    public int wrongSolution(String[][] relation) {
        int answer = 0;
        int total = relation.length;

        for (int i = 0; i < relation[0].length; i++) {
            String[] attr = getAttr(relation, i);
            if (isUnique(attr, total)) {
                answer++;
                continue;
            }
            for (int j = i + 1; j < relation[0].length; j++) {
                String[] sums = sumStrings(attr, getAttr(relation, j));
                if (!isUnique(sums, total)) attr = sums;
                else answer++;
            }
        }

        return answer;
    }

    private String[] getAttr(String[][] r, int a) {
        String[] attrs = new String[r.length];
        for (int i = 0; i < attrs.length; i++) {
            attrs[i] = r[i][a];
        }
        return attrs;
    }

    private String[] sumStrings(String[] A, String[] B) {
        String[] sums = new String[A.length];

        for (int i = 0; i < A.length; i++) {
            sums[i] = A[i] + "." + B[i];
        }

        return sums;
    }

    private boolean isUnique(String[] tuple, int total) {
        Set<String> set = new HashSet<>();

        for (String t : tuple) set.add(t);

        return set.size() == total;
    }

}
