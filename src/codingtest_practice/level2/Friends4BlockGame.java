//https://school.programmers.co.kr/learn/courses/30/lessons/17679
//2022-11-09
//프렌즈 4 블록

package codingtest_practice.level2;

import java.util.*;

public class Friends4BlockGame {

    private char[][] boardInfo;
    private boolean[][] erase;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        toCharArray(board);

        while (padding(m, n)) {
            answer += eraseSquare(m, n);
            gravity(m, n);
        }

        return answer;
    }

    private boolean alreadyBlank(int row, int col) {
        return boardInfo[row][col] == '0';
    }

    private void gravity(int m, int n) {
        for (int col = 0; col < n; col++) {
            for (int row = m - 1; row > 0; row--) {
                if (boardInfo[row][col] == '0') {
                    int curr = row;
                    while (row > 0 && boardInfo[row][col] == '0') {
                        row--;
                    }
                    boardInfo[curr][col] = boardInfo[row][col];
                    boardInfo[row][col] = '0';
                    row = curr;
                }
            }
        }
    }

    private int eraseSquare(int m, int n) {
        int sum = 0;
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                if (erase[row][col]) {
                    sum += alreadyBlank(row, col) ? 0 : 1;
                    sum += alreadyBlank(row + 1, col) ? 0 : 1;
                    sum += alreadyBlank(row, col + 1) ? 0 : 1;
                    sum += alreadyBlank(row + 1, col + 1) ? 0 : 1;
                    boardInfo[row][col] = '0';
                    boardInfo[row + 1][col] = '0';
                    boardInfo[row][col + 1] = '0';
                    boardInfo[row + 1][col + 1] = '0';
                }
            }
        }
        return sum;
    }

    private boolean padding(int m, int n) {
        boolean change = false;
        erase = new boolean[m - 1][n - 1];
        for (int row = 0; row < m - 1; row++) {
            for (int col = 0; col < n - 1; col++) {
                char block = boardInfo[row][col];
                if (block == '0') continue;
                if (block == boardInfo[row + 1][col] &&
                        block == boardInfo[row][col + 1] &&
                        block == boardInfo[row + 1][col + 1]) {
                    erase[row][col] = true;
                    change = true;
                }
            }
        }
        return change;
    }

    private void toCharArray(String[] board) {
        int r = 0, c = 0;
        boardInfo = new char[board.length][board[0].length()];
        for (String row : board) {
            for (char col : row.toCharArray()) {
                boardInfo[r][c++] = col;
            }
            r++;
            c = 0;
        }
    }
}
