//https://school.programmers.co.kr/learn/courses/30/lessons/43105
//2022-10-21
//정수 삼각형

package codingtest_practice.level3;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] pathSum = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            pathSum[i] = new int[triangle[i].length];
        }
        pathSum[0][0] = triangle[0][0];

        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                pathSum[i + 1][j] = Math.max(triangle[i + 1][j] + pathSum[i][j], pathSum[i + 1][j]);
                pathSum[i + 1][j + 1] = Math.max(triangle[i + 1][j + 1] + pathSum[i][j], pathSum[i + 1][j + 1]);
            }
        }
        for (int num : pathSum[pathSum.length - 1]) {
            answer = Math.max(answer, num);
        }

        return answer;
    }
}
