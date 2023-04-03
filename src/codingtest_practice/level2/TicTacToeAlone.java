//2023-04-03
//https://school.programmers.co.kr/learn/courses/30/lessons/160585
//혼자서 하는 틱택토

package codingtest_practice.level2;

import java.util.*;

public class TicTacToeAlone {
    private Set<String> winners;

    public int solution(String[] board) {
        winners = new HashSet<>();
        return isPossible(board) ? 1 : 0;
    }

    private boolean isPossible(String[] board) {
        List<String> lines = new ArrayList<>(Arrays.asList(board));
        for (int i = 0; i < board.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (String s : board) {
                temp.append(s.charAt(i));
            }
            lines.add(temp.toString());
        }
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            temp.append(board[i].charAt(i));
        }
        lines.add(temp.toString());
        temp = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            temp.append(board[i].charAt(2 - i));
        }
        lines.add(temp.toString());

        int diff = countOX(board, 'O') - countOX(board, 'X');

        if (diff < 0 || diff >= 2) return false;

        for (String line : lines) {
            checkWinner(line);
        }

        if (winners.size() >= 2) {
            return false;
        } else if (winners.contains("O")) {
            return diff == 1;
        } else if (winners.contains("X")) {
            return diff == 0;
        } else {
            return true;
        }
    }

    private void checkWinner(String line) {
        char[] lts = line.toCharArray();
        char f = lts[0];
        if (f == '.') return;
        if (f == lts[1] && f == lts[2]) {
            winners.add("" + f);
        }
    }

    private int countOX(String[] board, char OX) {
        int o = 0;

        for (String line : board) {
            for (char c : line.toCharArray()) {
                if (c == OX) o++;
            }
        }
        return o;
    }
}
