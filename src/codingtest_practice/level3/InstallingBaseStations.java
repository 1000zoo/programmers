//2023=08=18
//https://school.programmers.co.kr/learn/courses/30/lessons/12979
//기지국 설치

package codingtest_practice.level3;

public class InstallingBaseStations {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int l = 1;
        int[][] ranges = getRanges(stations, w);

        for (int[] range : ranges) {
            if (l > range[0]) {
                l = range[1] + 1;
                continue;
            }
            answer += ceil((range[0] - l), (2 * w + 1));
            l = range[1] + 1;
        }
        answer += ceil((n - l + 1), (2 * w + 1));
        return answer;
    }

    private int ceil(int n, int r) {
        if (n <= 0) return 0;
        return n % r == 0 ? n / r : (n / r) + 1;
    }

    private int[][] getRanges(int[] stations, int w) {
        int[][] ranges = new int[stations.length][];

        for (int i = 0; i < stations.length; i++) {
            ranges[i] = new int[]{stations[i] - w, stations[i] + w};
        }
        return ranges;
    }
}
