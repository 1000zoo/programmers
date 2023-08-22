//https://school.programmers.co.kr/learn/courses/30/lessons/42889
//2022-10-23
//실패율

package codingtest_practice.level1;

import java.util.*;

public class FailRate {

    public int[] newSolution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int total = 0;
            int fail = 0;
            for (int stage : stages) {
                total += stage >= i ? 1 : 0;
                fail += stage == i ? 1 : 0;
            }
            if (total == 0) map.put(i, 0.0);
            else map.put(i, (double) fail / total);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((i1, i2) -> Double.compare(map.get(i2), map.get(i1)));

        return keys.stream().mapToInt(i -> i).toArray();
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        SortedMap<Double, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 1; i <= N; i++) {
            int clear = 0;
            int fail = 0;
            for (int stage : stages) {
                if (stage > i) clear++;
                else if (stage == i) fail++;
            }
            double failRate = 0;
            if (fail != 0) {
                failRate = (double) fail / (clear + fail);
            }
            List<Integer> temp = map.getOrDefault(failRate, new ArrayList<>());
            temp.add(i);
            map.put(failRate, temp);

        }
        List<Integer> list = new ArrayList<>();
        for (double key : map.keySet()) {
            list.addAll(map.get(key));
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
