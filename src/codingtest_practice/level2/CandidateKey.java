//2023-09-08
//https://school.programmers.co.kr/learn/courses/30/lessons/42890#
//후보키

package codingtest_practice.level2;

import java.util.*;

public class CandidateKey {

    public int solution(String[][] relation) {
        int columnLength = relation[0].length;

        List<List<Integer>> combinations = new ArrayList<>();
        for (int i = 1; i <= columnLength; i++) {
            combinations.addAll(generateCombinations(columnLength, i));
        }

        Set<Set<Integer>> candidateKeys = new HashSet<>();

        for (List<Integer> combination : combinations) {
            List<String> tuples = new ArrayList<>();
            for (String[] row : relation) {
                StringBuilder sb = new StringBuilder();
                for (int index : combination) {
                    sb.append(row[index]).append(" ");
                }
                tuples.add(sb.toString().trim());
            }

            if (isUnique(tuples) && checkMinimality(candidateKeys, new HashSet<>(combination))) {
                candidateKeys.add(new HashSet<>(combination));
            }
        }

        return candidateKeys.size();
    }

    public List<List<Integer>> generateCombinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinationsUtil(result, new ArrayList<>(), n, k, 0);
        return result;
    }

    private void generateCombinationsUtil(List<List<Integer>> result, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < n; i++) {
            temp.add(i);
            generateCombinationsUtil(result, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean isUnique(List<String> list) {
        Set<String> set = new HashSet<>(list);
        return set.size() == list.size();
    }

    public boolean checkMinimality(Set<Set<Integer>> candidateKeys, Set<Integer> newKey) {
        for (Set<Integer> existingKey : candidateKeys) {
            if (newKey.containsAll(existingKey)) {
                return false;
            }
        }
        return true;
    }
}
