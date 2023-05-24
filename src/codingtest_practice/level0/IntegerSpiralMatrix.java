//2023-05-25
//https://school.programmers.co.kr/learn/courses/30/lessons/181832
//정수를 나선형으로 배치하기

package codingtest_practice.level0;

public class IntegerSpiralMatrix {

    private boolean[][] visited;
    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int index = 0;
    private int boundary = 0;

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        visited = new boolean[n][n];
        boundary = n;
        int i = 0;
        int j = 0;
        int num = 1;

        while (num <= n * n) {
            answer[i][j] = num++;
            visited[i][j] = true;
            i += directions[index % 4][0];
            j += directions[index % 4][1];
            checkDirection(i, j);
        }

        return answer;
    }

    private void checkDirection(int i, int j) {
        int ni = i + directions[index % 4][0];
        int nj = j + directions[index % 4][1];
        if (!isWithinBoundary(ni, nj)) {
            index++;
            return;
        }
        if (visited[ni][nj]) {
            index++;
        }
    }

    private boolean isWithinBoundary(int i, int j) {
        return 0 <= i && i < boundary && 0 <= j && j < boundary;
    }
}
