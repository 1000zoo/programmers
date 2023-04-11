//2023-04-11
//https://school.programmers.co.kr/learn/courses/30/lessons/178871
//달리기 경주

package codingtest_practice.level1;

import java.util.*;

public class RunningRace {

    //Time Complexity : O(players.length + callings.length) => O(N)
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            int rank = map.get(calling);
            String called = players[rank];
            String front = players[rank - 1];
            players[rank] = front;
            players[rank - 1] = called;
            map.put(called, rank - 1);
            map.put(front, rank);
        }

        return players;
    }
}
