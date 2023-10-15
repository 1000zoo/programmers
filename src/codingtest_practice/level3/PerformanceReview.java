//2023-10-15
//
//인사고과

package codingtest_practice.level3;

import java.util.*;

public class PerformanceReview {

    public int solution(int[][] scores) {
        int answer = 1;
        int maxB = -1;
        int[] wanho = scores[0];

        Arrays.sort(scores, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        for (int[] score : scores) {
            if (maxB <= score[1]) {
                maxB = score[1];
                if (score[0] + score[1] > wanho[0] + wanho[1]) {
                    answer++;
                }
                continue;
            }
            if (Arrays.equals(score, wanho)) {
                return -1;
            }
        }

        return answer;
    }

    // 25번 시간초과
    public int timeLimit(int[][] scores) {
        int answer = 1;
        int wonhoSum = scores[0][0] + scores[0][1];

        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> aceList = getAce(scores);

        if (!canGetIncentive(aceList, scores[0])) return -1;

        for (int[] score : scores) {
            if (!canGetIncentive(aceList, score)) continue;
            int sum = score[0] + score[1];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Collections.reverseOrder());

        for (int key : keyList) {
            if (key == wonhoSum) {
                return answer;
            }
            answer += map.get(key);
        }

        return answer;
    }

    private boolean canGetIncentive(List<int[]> aceList, int[] score) {
        for (int[] ace : aceList) {
            if (score[0] < ace[0] && score[1] < ace[1]) {
                return false;
            }
        }
        return true;
    }

    private List<int[]> getAce(int[][] scores) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();

        for (int[] score : scores) {
            if (map.containsKey(score[0])) {
                map.put(score[0], Math.max(map.get(score[0]), score[1]));
                continue;
            }
            map.put(score[0], score[1]);
        }

        for (int key : map.keySet()) {
            list.add(new int[] {key, map.get(key)});
        }

        return list;
    }
}
