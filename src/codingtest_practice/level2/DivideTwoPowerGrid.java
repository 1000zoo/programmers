//2023-08-07
//https://school.programmers.co.kr/learn/courses/30/lessons/86971#
//전력망 둘로 나누기

package codingtest_practice.level2;

import java.util.*;

class DivideTwoPowerGrid {
    Map<Integer, Set<Integer>> map;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        setMap(wires);

        for (int[] wire : wires) {   //끊을 wire
            map.get(wire[0]).remove(wire[1]);
            map.get(wire[1]).remove(wire[0]);
            answer = Math.min(answer, Math.abs(getSize(wire[0]) - getSize(wire[1])));
            map.get(wire[0]).add(wire[1]);
            map.get(wire[1]).add(wire[0]);
        }
        
        
        return answer;
    }
    
    private int getSize(int node) {
        return Math.max(1, traversal(new HashSet<>(), node, 0));
    }
    
    private int traversal(Set<Integer> visited, int curr, int size) {
        Set<Integer> currLinks = new HashSet<>(map.get(curr));
        
        for (int l : currLinks) {
            if (!visited.contains(l)) {
                visited.add(l);
                size = traversal(visited, l, size + 1);
            }
        }
        return size;
    }
    
    private void setMap(int[][] wires) {
        map = new HashMap<>();
        for (int i = 1; i <= wires.length + 1; i++) {
            map.put(i, new HashSet<>());
        }
        
        for (int[] wire : wires) {
            Set<Integer> temp = map.getOrDefault(wire[0], new HashSet<>());
            temp.add(wire[1]);
            map.put(wire[0], temp);
            temp = map.getOrDefault(wire[1], new HashSet<>());
            temp.add(wire[0]);
            map.put(wire[1], temp);
        }
    }

//틀린 풀이
    public int wrongSolution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                if (set1.isEmpty() || atLeastContainsOne(set1, wires[j])) {
                    add(set1, wires[j]);
                } else {
                    add(set2, wires[j]);
                }
            }
            if (!set1.contains(wires[i][0])) {
                set2.add(wires[i][0]);
            } else if (!set1.contains(wires[i][1])) {
                set2.add(wires[i][1]);
            }
            answer = Math.min(answer, Math.abs(set1.size() - set2.size()));
        }
        
        return answer;
    }
    
    private boolean atLeastContainsOne(Set<Integer> set, int[] wire) {
        return set.contains(wire[0]) || set.contains(wire[1]);
    }
    
    private void add(Set<Integer> set, int[] wire) {
        set.add(wire[0]);
        set.add(wire[1]);
    }
}
