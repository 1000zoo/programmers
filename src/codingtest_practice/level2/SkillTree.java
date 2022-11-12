//https://school.programmers.co.kr/learn/courses/30/lessons/49993#fn1
//2022-11-12
//스킬 트리

package codingtest_practice.level2;

import java.util.*;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String tree : skill_trees) {
            if (isPossibleTree(skill, tree)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isPossibleTree(String skill, String tree) {
        Queue<Character> q = new LinkedList<>();

        for (char c : skill.toCharArray()) {
            q.offer(c);
        }

        for (char c : tree.toCharArray()) {
            if (q.peek() == c) {
                q.poll();
            } else if (q.contains(c)) {
                return false;
            }
            if (q.isEmpty()) {
                break;
            }
        }
        return true;
    }
}
