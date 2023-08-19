//2023-08-20
//https://school.programmers.co.kr/learn/courses/30/lessons/64064?language=java
//불량 사용자

package codingtest_practice.level3;

import java.util.*;

public class BlackConsumersId {
    private Map<Integer, List<String>> map;
    private Set<String> set;

    public int solution(String[] userId, String[] bannedId) {
        int answer = 0;
        map = new HashMap<>();
        set = new HashSet<>();

        for (int i = 0; i < bannedId.length; i++) {
            List<String> temp = new ArrayList<>();
            for (String user : userId) {
                if (isSame(user, bannedId[i])) temp.add(user);
            }
            map.put(i, temp);
        }

        dfs(0, new ArrayList<>());
        return set.size();
    }

    private void dfs(int index, ArrayList<String> selected) {
        if (index == map.size()) {
            ArrayList<String> temp = (ArrayList<String>)selected.clone();
            Collections.sort(temp);
            set.add(temp.toString());
            return;
        }

        for (String p : map.get(index)) {
            if (selected.contains(p)) continue;
            selected.add(p);
            dfs(index + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    private boolean isSame(String u, String b) {
        if (u.length() != b.length()) return false;

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == b.charAt(i) || b.charAt(i) == '*') continue;
            return false;
        }
        return true;
    }
}
