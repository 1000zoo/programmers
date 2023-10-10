//2023-10-10
//https://school.programmers.co.kr/learn/courses/30/lessons/92344
//파괴되지 않은 건물

package codingtest_practice.level3;

public class NotDestroyedBuildings {

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] prefix = prefixSumMatrix(skill, board.length, board[0].length);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer += board[i][j] + prefix[i][j] > 0 ? 1 : 0;
            }
        }

        return answer;
    }

    private int[][] prefixSumMatrix(int[][] skills, int h, int w) {
        int[][] prefix = new int[h + 1][w + 1];

        for (int[] skill : skills) {
            int num = sign(skill[0]) * skill[5];
            int r1 = skill[1];
            int c1 = skill[2];
            int r2 = skill[3];
            int c2 = skill[4];
            prefix[r1][c1] += num;
            prefix[r1][c2 + 1] += -num;
            prefix[r2 + 1][c1] += -num;
            prefix[r2 + 1][c2 + 1] += num;
        }
        sum(prefix);
        return prefix;
    }

    private void sum(int[][] prefix) {
        for (int i = 0; i < prefix.length; i++) {
            for (int j = 1; j < prefix[0].length; j++) {
                prefix[i][j] += prefix[i][j - 1];
            }
        }

        for (int i = 1; i < prefix.length; i++) {
            for (int j = 0; j < prefix[0].length; j++) {
                prefix[i][j] += prefix[i - 1][j];
            }
        }
    }

    private int sign(int type) {
        return type == 1 ? -1 : 1;
    }
}
