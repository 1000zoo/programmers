//2023-10-07
//https://school.programmers.co.kr/learn/courses/30/lessons/49191
//순위

package codingtest_practice.level3;

import java.util.*;

public class Rank {

    private Set<Integer> set;

    private static class Player {
        public int num;
        public List<Player> winList;
        public List<Player> loseList;

        public Player(int num) {
            this.num = num;
            winList = new ArrayList<>();
            loseList = new ArrayList<>();
        }

        public void addWin(Player p) {
            winList.add(p);
        }
        public void addLose(Player p) {
            loseList.add(p);
        }
        public String toString() {return "" + this.num;}
    }

    public int solution(int n, int[][] results) {
        int answer = 0;

        Map<Integer, Player> playerMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            playerMap.put(i, new Player(i));
        }

        for (int[] result : results) {
            Player winner = playerMap.get(result[0]);
            Player loser = playerMap.get(result[1]);

            winner.addLose(loser);
            loser.addWin(winner);
        }

        for (int i : playerMap.keySet()) {
            set = new HashSet<>();
            Player p = playerMap.get(i);
            winTraversal(p);
            set.remove(i);
            loseTraversal(p);
            if (set.size() == n) answer++;
        }

        return answer;
    }

    private void winTraversal(Player p) {
        if (set.contains(p.num)) return;
        set.add(p.num);
        if (p.winList.isEmpty()) {
            return;
        }
        for (Player winner : p.winList) {
            winTraversal(winner);
        }
    }

    private void loseTraversal(Player p) {
        if (set.contains(p.num)) return;
        set.add(p.num);
        if (p.loseList.isEmpty()) {
            return;
        }
        for (Player loser : p.loseList) {
            loseTraversal(loser);
        }
    }
}
