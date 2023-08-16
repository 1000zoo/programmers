//2023-08-16
//https://school.programmers.co.kr/learn/courses/30/lessons/12978
//배달

package codingtest_practice.level2;

import java.util.*;
import java.util.stream.IntStream;

public class DeliveryTime {

    public int newSolution(int N, int[][] road, int K) {
        int[] totals = new int[N + 1];
        Queue<Integer> pq = new LinkedList<>();

        int[][] w = new int[N + 1][N + 1];
        Arrays.fill(totals, 500001);
        totals[1] = 0;
        for (int i = 1; i <= N; i++) {
            Arrays.fill(w[i], 500001);
            w[i][i] = 0;
        }

        for (int[] r : road) {
            w[r[0]][r[1]] = Math.min(w[r[0]][r[1]], r[2]);
            w[r[1]][r[0]] = Math.min(w[r[1]][r[0]], r[2]);
        }

        for (int i = 2; i <= N; i++) {
            pq.add(1);
            while (!pq.isEmpty()) {
                int curr = pq.poll();
                for (int j = 1; j <= N; j++) {
                    if (totals[j] > totals[curr] + w[curr][j]) {
                        totals[j] = totals[curr] + w[curr][j];
                        pq.add(j);
                    }
                }
            }
        }

        return (int) IntStream.rangeClosed(1, N).filter(i -> totals[i] <= K).count();
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] w = setW(N, road);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    w[j][k] = Math.min(w[j][i] + w[k][i], w[j][k]);
                }
            }
        }

        for (int i : w[1]) {
            if (i <= K) answer++;
        }
        return answer;
    }

    private int[][] setW(int N, int[][] road) {
        int[][] w = new int[N + 1][N + 1];
        final int INF = 500001;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    w[i][j] = 0;
                } else {
                    w[i][j] = INF;
                }
            }
        }

        for (int[] r : road) {
            int t1 = w[r[0]][r[1]];
            w[r[0]][r[1]] = Math.min(t1, r[2]);
            w[r[1]][r[0]] = Math.min(t1, r[2]);
        }
        return w;
    }
}