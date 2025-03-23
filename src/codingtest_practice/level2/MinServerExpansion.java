package codingtest_practice.level2;

public class MinServerExpansion {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] n = new int[players.length];

        for (int i = 0; i < players.length; i++) {
            int currMax = (n[i] + 1) * m;
            if (players[i] >= currMax) {
                int d = (int) (Math.ceil(players[i] / m)) - n[i];
                add(n, i, d, k);
                answer += d;
            }
        }

        return answer;
    }

    private void add(int[] n, int index, int cnt, int k) {
        int min = Math.min(n.length, index + k);
        for (int i = index; i < min; i++) {
            n[i] += cnt;
        }
    }
}
