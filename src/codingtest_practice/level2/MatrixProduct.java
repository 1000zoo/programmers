//https://school.programmers.co.kr/learn/challenges?order=acceptance_desc&page=4&levels=1%2C2%2C3%2C5%2C4&languages=java
//2022-10-20
//행렬의 곱셈

package codingtest_practice.level2;

public class MatrixProduct {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
