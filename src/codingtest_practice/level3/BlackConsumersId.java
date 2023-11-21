//2023-08-20 (새로운 풀이: 2023-11-22)
//https://school.programmers.co.kr/learn/courses/30/lessons/64064?language=java
//불량 사용자

package codingtest_practice.level3;

import java.util.*;

public class BlackConsumersId {

    private final Set<String> checkDuplicate = new HashSet<>();

    public int solution(String[] userId, String[] bannedId) {
        List<List<String>> candidateList = new ArrayList<>();

        for (String id : bannedId) {
            candidateList.add(getCandidateListOf(id, userId));
        }
        recursion(candidateList, new HashSet<>(), 0);
        return checkDuplicate.size();
    }

    private void recursion(List<List<String>> list, Set<String> set, int index) {
        if (list.size() == index) {
            addSetToOrderedString(set);
            return;
        }

        List<String> currList = list.get(index);

        for (String id : currList) {
            if (set.contains(id)) {
                continue;
            }
            set.add(id);
            recursion(list, set, index + 1);
            set.remove(id);
        }
    }

    private void addSetToOrderedString(Set<String> set) {
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        checkDuplicate.add(list.toString());
    }

    private List<String> getCandidateListOf(String bannedId, String[] userId) {
        List<String> list = new ArrayList<>();

        for (String id : userId) {
            if (isPossible(id, bannedId)) {
                list.add(id);
            }
        }

        return list;
    }

    private boolean isPossible(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*' || bannedId.charAt(i) == userId.charAt(i)) {
                continue;
            }
            return false;
        }

        return true;
    }
}
