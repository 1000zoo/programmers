//2023-09-16
//https://school.programmers.co.kr/learn/courses/30/lessons/92342
//양궁대회

package codingtest_practice.level2;

import java.util.*;

public class ArcheryContest {

    private int[] answer;
    private int[] _info;
    private int maxDiff;

    public int[] solution(int n, int[] info) {
        answer = new int[11];
        _info = info;
        maxDiff = 0;
        partition(n, 0, new int[11]);
        if (Arrays.stream(answer).sum() == 0) return new int[] {-1};

        return answer;
    }

    private void partition(int n, int index, int[] arr) {
        if (n == 0 && index == arr.length) {
            int[] scores = getScore(arr);
            if (scores[0] >= scores[1]) return;
            if (scores[1] - scores[0] > maxDiff) {
                maxDiff = scores[1] - scores[0];
                answer = arr.clone();
            } else if (scores[1] - scores[0] == maxDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (answer[i] < arr[i]) {
                        answer = arr.clone();
                        break;
                    } else if (answer[i] > arr[i]) break;
                }
            }

            return;
        }
        if (n < 0 || index == 11) return;

        for (int i = 0; i <= n; i++) {
            arr[index] = i;
            partition(n - i, index + 1, arr);
        }
    }

    private int[] getScore(int[] r) {
        int aScore = 0;
        int rScore = 0;

        for (int i = 0; i < r.length; i++) {
            if (_info[i] == 0 && r[i] == 0) continue;
            if (_info[i] >= r[i]) aScore += (10 - i);
            else rScore += (10 - i);
        }

        return new int[] {aScore, rScore};
    }
}
