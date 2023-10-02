//2023-10-02
//https://school.programmers.co.kr/learn/courses/30/lessons/17678
//셔틀 버스

package codingtest_practice.level3;

import java.util.*;

public class ShuttleBus {

    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pq = new PriorityQueue<>();
        Map<Integer, List<Integer>> bus = new HashMap<>();

        for (String time : timetable) {
            pq.add(timeToInteger(time));
        }

        int firstTime = timeToInteger("09:00");

        for (int i = 0; i < n; i++) {
            int currentTime = firstTime + (i * t);
            List<Integer> list = new ArrayList<>();

            while (!pq.isEmpty() && pq.peek() <= currentTime && list.size() < m) {
                list.add(pq.poll());
            }
            Collections.sort(list);
            bus.put(currentTime, list);
        }

        int lastTime = firstTime + (n - 1) * t;
        List<Integer> lastQueue = bus.get(lastTime);
        lastTime = lastQueue.size() < m ? lastTime : lastQueue.get(m - 1);

        return intToTime(lastTime);
    }

    private String intToTime(int time) {
        int h = time / 60;
        int m = time % 60;

        String hour = String.valueOf(h);
        String minute = String.valueOf(m);

        return timeFormation(hour) + ":" + timeFormation(minute);
    }

    private String timeFormation(String t) {
        return t.length() == 1 ? "0" + t : t;
    }

    private int timeToInteger(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}
