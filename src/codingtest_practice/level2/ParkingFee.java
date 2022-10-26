//https://school.programmers.co.kr/learn/courses/30/lessons/92341
//2022-10-25
//주차 요금 계산

package codingtest_practice.level2;

import java.util.*;

public class ParkingFee {
    final private int MAX_TIME = 23 * 60 + 59;

    public int[] solution(int[] fees, String[] records) {

        TreeMap<Integer, int[]> map = new TreeMap<>();

        for (String s : records) {
            int[] info = decode(s);
            int[] temp = map.getOrDefault(info[0], new int[]{0, 0});
            if (temp[1] == 0) {
                temp[0] -= info[1];
                temp[1] = 1;
            } else {
                temp[0] += info[1];
                temp[1] = 0;
            }
            map.put(info[0], temp);
        }
        int[] answer = new int[map.size()];
        int index = 0;
        for (int id : map.keySet()) {
            int[] temp = map.get(id);
            System.out.println(id);
            if (temp[1] == 1) {
                temp[0] += MAX_TIME;
            }
            answer[index++] = calculateFee(fees, temp[0]);
        }

        return answer;
    }

    private int calculateFee(int[] fees, int totalTime) {
        int parkTime = totalTime;
        if (totalTime <= fees[0]) {
            return fees[1];
        }
        int time = totalTime - fees[0];
        int timeFee = (int) Math.ceil((double) time / fees[2]);
        return fees[1] + timeFee * fees[3];
    }

    private int[] decode(String record) {
        String[] ele = record.split(" ");
        int hour = Integer.parseInt(ele[0].split(":")[0]);
        int minute = Integer.parseInt(ele[0].split(":")[1]);
        int carId = Integer.parseInt(ele[1]);
        int type = ele[2].equals("IN") ? 1 : 0;
        int totalMinute = 60 * hour + minute;

        return new int[] {carId, totalMinute, type};
    }
}
