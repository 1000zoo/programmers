//2023-02-09
//https://school.programmers.co.kr/learn/courses/30/lessons/155651
//호텔 대실

package codingtest_practice.level2;

import java.util.*;

public class HotelReservation {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] array = toIntArray(book_time);
        Arrays.sort(array, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        Queue<int[]> room = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        for (int[] times : array) {
            while (!room.isEmpty() && room.peek()[1] <= times[0]) {
                room.poll();
            }
            room.add(times);
            answer = Math.max(answer, room.size());
        }

        return answer;
    }

    private int[][] toIntArray(String[][] book_time) {
        int[][] array = new int[book_time.length][book_time[0].length];
        for (int i = 0; i < book_time.length; i++) {
            String[] times = book_time[i];
            array[i][0] = timeToInt(times[0]);
            array[i][1] = timeToInt(times[1]) + 10;
        }
        return array;
    }

    private int timeToInt(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}
