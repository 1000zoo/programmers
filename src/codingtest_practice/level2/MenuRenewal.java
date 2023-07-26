//2023-07-27
//https://school.programmers.co.kr/learn/courses/30/lessons/72411
//메뉴 리뉴얼

package codingtest_practice.level2;

import java.util.*;


class MenuRenewal {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        List<Set<String>> setList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        for (int c : course) min = Math.min(min, c);

        for (String order : orders) {
            Set<String> temp = new HashSet<>();
            for (char c : order.toCharArray()) temp.add("" + c);
            setList.add(temp);
        }

        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = i + 1; j < orders.length; j++) {
                Set<String> temp1 = setList.get(i);
                Set<String> temp2 = setList.get(j);
                int sub = sub(temp1, temp2);

                for (int k = min; k <= sub; k++) {
                    String comb = retainString(temp1, temp2);
                    char[] arr = comb.toCharArray();
                    Arrays.sort(arr);
                    String sortedOrder = new String(arr);
                    dfs(sortedOrder, "", 0, k, map, new HashSet<>());
                }
            }
        }


        Map<Integer, List<String>> maxKeysMap = new HashMap<>();
        Map<Integer, Integer> maxValuesMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int keyLength = entry.getKey().length();
            int value = entry.getValue();

            if (!maxValuesMap.containsKey(keyLength) || value > maxValuesMap.get(keyLength)) {
                maxValuesMap.put(keyLength, value);
                maxKeysMap.put(keyLength, new ArrayList<>());
            }

            if (value == maxValuesMap.get(keyLength)) {
                maxKeysMap.get(keyLength).add(entry.getKey());
            }
        }

        List<String> result = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int i : course) {
            set.add(i);
        }
        for (int key : maxKeysMap.keySet()) {
            if (set.contains(key)) {
                result.addAll(maxKeysMap.get(key));
            }
        }
        Collections.sort(result);


        return result.toArray(new String[0]);
    }

    private void dfs(String origin, String curr, int currIndex,
                     int max, Map<String, Integer> map, Set<Character> usedChars) {
        if (curr.length() == max) {
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            return;
        }

        for (int i = currIndex; i < origin.length(); i++) {
            char c = origin.charAt(i);
            if (!usedChars.contains(c)) {
                usedChars.add(c);
                dfs(origin, curr + c, i + 1, max, map, usedChars);
                usedChars.remove(c);
            }
        }
    }
    private String retainString(Set<String> set1, Set<String> set2) {
        Set<String> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        return String.join("", temp);
    }

    private int sub(Set<String> set1, Set<String> set2) {
        Set<String> temp = new HashSet<>(set1);
        temp.removeAll(set2);
        return set1.size() - temp.size();
    }
}